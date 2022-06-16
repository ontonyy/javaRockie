package com.example.FujitsuHomeWork.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.*;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovieParser {

    /**
     * With omdbapi movie converter to JSON and YAML
     * @param movieName that will be converted and added to json and yml
     * @return movie from omdbapi json-url
     */
    public Movie convertToMovie(String movieName) {
        String link = "http://www.omdbapi.com/?t=" + movieName + "&apikey=31dc65a9";
        String streamString = readStream(link);
        JSONObject jsonFromUrl = new JSONObject(streamString);

        if (jsonFromUrl.get("Response").equals("True")) {
            Movie movie = createMovie(jsonFromUrl);
            JSONObject movieJson = convertToJson(movie);
            Map<String, Movie> movieYaml = convertToYaml(movie);

            writeJsonToFile(movieJson);
            writeYamlToFile(movieYaml);
            return movie;
        } else {
            System.out.println("[!] Write correct movie title, you try: " + movieName);
            return null;
        }
    }

    /**
     * Write data(movie data) to .yml file
     * @param movieYaml data that will be writted to yaml file
     */
    private void writeYamlToFile(Map<String, Movie> movieYaml) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try (FileWriter out = new FileWriter("src/main/resources/movies.yml", true)) {
            mapper.writeValue(out, movieYaml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param movie class
     * @return data map with title and movie class
     */
    private Map<String, Movie> convertToYaml(Movie movie) {
        Map<String, Movie> main = new LinkedHashMap<>();
        main.put(movie.getTitle(), movie);
        return main;
    }

    /**
     * Simple reader from url stream
     * @param link URL, stream of this will be used
     * @return String that was read
     */
    public String readStream(String link) {
        StringBuilder main = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(link).openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                main.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return main.toString();
    }

    /**
     *
     * @param object that will be added to .json file
     */
    public void writeJsonToFile(Object object) {
        try (FileWriter out = new FileWriter("src/main/resources/movies.json", true)) {
            out.write(object + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param movie class that will be converted to JSONObject
     * @return movie json with title
     */
    public JSONObject convertToJson(Movie movie) {
        Gson gson = new GsonBuilder().create();
        JSONObject jsonMovie = new JSONObject();

        String jsonString = gson.toJson(movie);
        jsonMovie.put(movie.getTitle(), new JSONObject(jsonString));
        return jsonMovie;
    }

    /**
     * Before creating, check json have all info that needed, and then create
     * @param jsonMovie with data, that will be used to movie creating
     * @return movie that was created
     */
    public Movie createMovie(JSONObject jsonMovie) {
        Movie movie = null;
        try {
            List<String> genres = List.of();
            if (jsonMovie.has("Genre")) {
                 genres = parseStringToList(jsonMovie.get("Genre"));
            }
            List<String> actorsList = List.of();
            if (jsonMovie.has("Actors")) {
                actorsList = parseStringToList(jsonMovie.get("Actors"));
            }
            int boxOffice = 0;
            if (jsonMovie.has("BoxOffice")) {
                boxOffice = Integer.parseInt(jsonMovie.get("BoxOffice").toString().replace("$", "").replace(",", ""));
            }
            float imdbRating = 0f;
            if (jsonMovie.has("imdbRating")) {
                imdbRating = Float.parseFloat(jsonMovie.get("imdbRating").toString());
            }
            movie = new Movie(jsonMovie.get("Title").toString(), genres, jsonMovie.get("Released").toString(),
                    actorsList, imdbRating, boxOffice);
        } catch (Exception ex) {
            System.out.println("Try again write movie name!");
        }
        return movie;
    }

    /**
     * @param str that will be parsed to list
     * @return list from string
     */
    private List<String> parseStringToList(Object str) {
        return List.of(str.toString().split(", "));
    }
}
