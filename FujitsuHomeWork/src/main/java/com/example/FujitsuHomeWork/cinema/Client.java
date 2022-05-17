package com.example.FujitsuHomeWork.cinema;

import java.util.*;

public class Client {
    private String name;
    private int money;
    private Map<Movie, Integer> movies;

    /**
     * Client that can rent some movies and check their price
     * @param name of client
     * @param money that client has
     */
    public Client(String name, int money) {
        this.name = name;
        this.money = money;
        this.movies = new LinkedHashMap<>();
    }

    /**
     * Update client movies info about rent days (decrease),
     * if rent days is over, then movie will be free
     */
    public void checkMoviesRent() {
        List<Movie> moviesRemove = new LinkedList<>();
        for (Map.Entry<Movie, Integer> movieFloatEntry : movies.entrySet()) {
            Movie movie = movieFloatEntry.getKey();
            if (movie.getRentDays() <= 0) {
                movie.setRentDateNull();
                movie.setRentDays(-1);
                moviesRemove.add(movie);
            }
            movies.put(movie, movie.getRentDays());
        }
        moviesRemove.forEach(movies.keySet()::remove);
    }

    /**
     * Check if movie not rented, if no, then client rent movie to some days
     * and pay immediately for rental price
     * @param movie that client will rent
     * @param daysOfRent how much movie will be on this client, and check rental price
     */
    public void orderMovie(Movie movie, int daysOfRent) {
        if (movie.getRentDate() == -1 && movie.getRentDays() == -1) {
            movie.setRentDays(daysOfRent);
            movie.setRentDate();
            money -= movie.getMoviePriceForDays(daysOfRent);
            movies.put(movie, movie.getRentDays());
        }
    }

    public String getName() {
        return name;
    }

    public Map<Movie, Integer> getMovies() {
        return movies;
    }

    /**
     * @param movieTitle that rented and will be checked
     * @return rent days of special movie
     */
    public float getMovieRentDays(String movieTitle) {
        for (Movie movie : movies.keySet()) {
            if (movie.getTitle().equals(movieTitle)) {
                return movies.get(movie);
            }
        }
        return 0f;
    }

    public int getMoney() {
        return money;
    }
}
