package com.example.FujitsuHomeWork.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    List<String> actors = new LinkedList<>();
    List<String> genres = new LinkedList<>();
    Movie movie = null;

    @BeforeEach
    void fillMovie() {
        genres.add("Comedy");
        genres.add("Triller");
        genres.add("Romantic");
        actors.add("Ryan Gosling");
        actors.add("Bryan");
        actors.add("Korzh");
        movie = new Movie("Avatar", genres, "17 Aug 2002", actors, 7.1f, 20000);
    }

    /**
     * Get movie for 14 days, and it will cost 3.98
     */
    @Test
    void getMoviePriceForDays() {
        assertEquals(3.98, Math.round(movie.getMoviePriceForDays(14) * 100.0) / 100.0);
    }

    @Test
    void setPriceByReleaseDay() {
        movie.setPriceByReleaseDay(new Date().getTime());
        assertEquals(1.99f, movie.getPrice());
    }

    @Test
    void setPrice() {
        movie.setPrice();
        assertEquals(1.99f, movie.getPrice());
    }

    @Test
    void parseMonth() {
        assertEquals("01", movie.parseMonth("Jan"));
    }

    @Test
    void getPrice() {
        assertEquals(1.99f, movie.getPrice());
    }

    @Test
    void getTitle() {
        assertEquals("Avatar", movie.getTitle());
    }

    @Test
    void setTitle() {
        movie.setTitle("Avatar 2");
        assertEquals("Avatar 2", movie.getTitle());
    }

    @Test
    void getReleased() {
        assertEquals("17 08 2002", movie.getReleased());
    }

    @Test
    void setReleased() {
        movie.setReleased("01 01 2002");
        assertEquals("01 01 2002", movie.getReleased());
    }

    @Test
    void getActors() {
        assertEquals(3, movie.getActors().size());
    }

    @Test
    void setActors() {
        movie.setActors(List.of("Ryan Gosling"));
        assertEquals(1, movie.getActors().size());
    }

    @Test
    void getRating() {
        assertEquals(7.1f, movie.getRating());
    }

    @Test
    void setRating() {
        movie.setRating(0f);
        assertEquals(0, movie.getRating());
    }

    @Test
    void getPayBox() {
        assertEquals(20000, movie.getPayBox());
    }

    @Test
    void setPayBox() {
        movie.setPayBox(100);
        assertEquals(100, movie.getPayBox());
    }

    @Test
    void getGenre() {
        assertEquals(3, movie.getGenre().size());
    }

    @Test
    void setGenre() {
        movie.setGenre(List.of("Comedy"));
        assertEquals(1, movie.getGenre().size());
    }

    @Test
    void getRentDays() {
        assertEquals(-1, movie.getRentDays());
    }

    @Test
    void setRentDateNull() {
        movie.setRentDateNull();
        assertEquals(-1, movie.getRentDate());
    }

    @Test
    void getRentDate() {
    }

    @Test
    void setRentDate() {
    }

    @Test
    void getNowDate() {
    }

    @Test
    void testToString() {
    }
}