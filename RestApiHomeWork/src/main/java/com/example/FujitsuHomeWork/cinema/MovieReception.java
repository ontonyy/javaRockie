package com.example.FujitsuHomeWork.cinema;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieReception {
    private Map<String, Client> clients;
    private Map<String, Movie> movies;
    private MovieParser movieParser;

    /**
     * Set null variables to Object
     */
    public MovieReception() {
        clients = new LinkedHashMap<>();
        movies = new LinkedHashMap<>();
        movieParser = new MovieParser();
    }

    /**
     * Clients check their movies rent days
     */
    public void clientsCheckMoviesRent() {
        for (Client client : clients.values()) {
            client.checkMoviesRent();
        }
    }

    public void addClient(Client client) {
        clients.put(client.getName(), client);
    }

    public Client getClientByName(String name) {
        return clients.get(name);
    }

    public void removeClient(String clientName) {
        clients.remove(clientName);
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getTitle(), movie);
    }

    /**
     * @param category that will sort of list movies
     * @return movies by category
     */
    public List<Movie> getMoviesByCategory(String category) {
        List<Movie> categoryMovies = new LinkedList<>();
        for (Movie value : movies.values()) {
            if (value.getGenre().contains(category)) {
                categoryMovies.add(value);
            }
        }
        return categoryMovies;
    }

    public void removeMovie(String movieTitle) {
        movies.remove(movieTitle);
    }

    public MovieParser getMovieController() {
        return movieParser;
    }

    /**
     * @param movieTitle will be used in link, then gain data about movie and create movie class
     * @return movie, if it can be created
     */
    public Movie addMovieByTitle(String movieTitle) {
        Movie movie = getMovieByName(movieTitle);
        if (movie == null) {
            movie = movieParser.convertToMovie(movieTitle);
            if (movie != null && !movies.containsKey(movie.getTitle())) {
                addMovie(movie);
                return movie;
            }
        }
        return movie;
    }

    /**
     * @param movieTitle from it create movie class
     * @param client that will order movie for some date
     * @param daysOfRent that client set
     */
    public void addMovieToClient(String movieTitle, Client client, Integer daysOfRent) {
        client.orderMovie(addMovieByTitle(movieTitle), daysOfRent);
    }

    /**
     * Special check of movie, because not always movie title that client writes
     * is movie title
     * @param title of movie that will be found in map
     * @return movie if movie map has movie with this title
     */
    public Movie getMovieByName(String title) {
        for (String s : movies.keySet()) {
            s = s.replaceAll(" ", "");
            if (s.toLowerCase().contains(title.toLowerCase())) {
                return movies.get(s);
            }
        }
        return null;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public Map<String, Movie> getMovies() {
        return movies;
    }

    public static void main(String[] args) {
        MovieReception reception = new MovieReception();
        Client client = new Client("Stasan", 10000);
        reception.addClient(client);
        System.out.println(client.getMoney());
        reception.addMovieToClient("The Avengers", client, 14);
        reception.addMovieToClient("Gerakl", client, 28);
        reception.addMovieToClient("ssss", client, 56);
        System.out.println(client.getMoney());
        System.out.println(client.getMovies());
        reception.clientsCheckMoviesRent();
        reception.clientsCheckMoviesRent();
        reception.clientsCheckMoviesRent();
        reception.clientsCheckMoviesRent();
        System.out.println(client.getMovies());
    }
}
