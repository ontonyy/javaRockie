package com.example.FujitsuHomeWork.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieReceptionTest {

    Movie movie2 = null;
    Client client2 = null;
    MovieReception reception = new MovieReception();

    @BeforeEach
    void fillReception() {
        Movie movie = new Movie("Avatar", new LinkedList<>(), "17 Aug 2002", new LinkedList<>(), 7.1f, 20000);
        movie2 = new Movie("Spider Man", List.of("Comedy"), "13 Jan 1998", new LinkedList<>(), 5.3f, 1000000);
        Client client = new Client("Stas", 1000);
        client2 = new Client("Maxim", 100);
        reception.addMovie(movie);
        reception.addMovie(movie2);
        reception.addClient(client);
    }
    @Test
    void clientsCheckMoviesRent() {
    }

    @Test
    void addClient() {
        reception.addClient(client2);
        assertEquals(2, reception.getClients().size());
    }

    @Test
    void getClientByName() {
        assertEquals(1000, reception.getClientByName("Stas").getMoney());
    }

    @Test
    void removeClient() {
        reception.removeClient("Stas");
        assertEquals(0, reception.getClients().size());
    }

    @Test
    void addMovie() {
        reception.addMovie(movie2);
        assertEquals(2, reception.getMovies().size());
    }

    @Test
    void getMoviesByCategory() {
        assertEquals(1, reception.getMoviesByCategory("Comedy").size());
    }

    @Test
    void removeMovie() {
        reception.removeMovie("Avatar");
        assertEquals(1, reception.getMovies().size());
    }

    @Test
    void addMovieByTitle() {
        reception.addMovieByTitle("Dragon");
        assertEquals(3, reception.getMovies().size());
    }

    @Test
    void addMovieToClient() {
        assertEquals(0, client2.getMovies().size());
        reception.addMovieToClient("Avatar", client2, 14);
        assertEquals(1, client2.getMovies().size());
    }

    @Test
    void getMovieByName() {
        assertEquals(20000, reception.getMovieByName("Avatar").getPayBox());
    }

    @Test
    void getClients() {
        assertEquals(1, reception.getClients().size());
    }

    @Test
    void getMovies() {
        assertEquals(2, reception.getMovies().size());
    }
}