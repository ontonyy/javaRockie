package com.example.FujitsuHomeWork.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieReception reception;

    @PutMapping("/{clientName}/{movieName}/{days}")
    public void addMovieToClient(@PathVariable String clientName, @PathVariable String movieName, @PathVariable int days) {
        reception.addMovieToClient(movieName, reception.getClientByName(clientName), days);
    }

    @PutMapping("/movies/add/{title}")
    public void addMovie(@PathVariable String title) {
        reception.addMovieByTitle(title);
    }

    @PutMapping("/clients/add/{title}/{money}")
    public void addClient(@PathVariable String title, @PathVariable int money) {
        reception.addClient(new Client(title, money));
    }

    @GetMapping("/movies/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return reception.getMoviesByCategory(genre);
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return reception.getMovies().values().stream().toList();
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return reception.getClients().values().stream().toList();
    }

    @GetMapping("/clients/{name}")
    public Client getClientByName(@PathVariable String name) {
        return reception.getClientByName(name);
    }

    @GetMapping("/movies/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        return reception.getMovieByName(title);
    }

    @DeleteMapping("/movies/delete/{title}")
    public void deleteMovie(@PathVariable String title) {
        reception.removeMovie(title);
    }

    @DeleteMapping("/clients/delete/{name}")
    public void deleteClient(@PathVariable String name) {
        reception.removeClient(name);
    }
}
