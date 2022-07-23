package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    private Movie second = new Movie(2, "Forward", "http://", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    private Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    private Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    private Movie sixth = new Movie(6, "Trolls.WorldTour", "http://", "cartoon");
    private Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    private Movie eighth = new Movie(8, "DreamMakers", "http://", "animation");
    private Movie ninth = new Movie(9, "Missing", "http://", "thriller");
    private Movie tenth = new Movie(10, "RocketScientist", "http://", "drama");

Movie[] expected = {tenth,ninth, eighth,seventh,sixth,fifth,fourth, third, second, first};

    @Test
    public void addMovie() {
        manager = new MovieManager();
        manager.add(String.valueOf(fifth));
        manager.add(String.valueOf(second));
        manager.add(String.valueOf(third));
        manager.add(String.valueOf(fourth));

        Movie newMovie = new Movie(11, "threeСats", "http://", "cartoon");
        manager.add(String.valueOf(newMovie));
        String[] actual = manager.findAll();
        String[] expected = {String.valueOf(fifth), String.valueOf(second), String.valueOf(third), String.valueOf(fourth), String.valueOf(new Movie(11, "threeСats", "http://", "cartoon"))};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void settingLimit() {
        manager = new MovieManager(5);
        manager.add(String.valueOf(first));
        manager.add(String.valueOf(second));
        manager.add(String.valueOf(third));
        manager.add(String.valueOf(fourth));
        manager.add(String.valueOf(fifth));

        String[] actual = manager.findAll();
        String[] expected = {String.valueOf(first), String.valueOf(second), String.valueOf(third), String.valueOf(fourth), String.valueOf(first)};

    }

    @Test
    public void ListAllMoviesInTheOrderTheyWereAdded() {
        manager = new MovieManager();
        manager.add(String.valueOf(first));
        manager.add(String.valueOf(second));
        manager.add(String.valueOf(third));
        manager.add(String.valueOf(fourth));
        manager.add(String.valueOf(fifth));
        manager.add(String.valueOf(sixth));
        manager.add(String.valueOf(seventh));
        manager.add(String.valueOf(eighth));
        manager.add(String.valueOf(ninth));
        manager.add(String.valueOf(tenth));

        String[] actual = manager.findAll();
        String[] expected = {String.valueOf(first), String.valueOf(second), String.valueOf(third), String.valueOf(fourth), String.valueOf(fifth), String.valueOf(sixth), String.valueOf(seventh), String.valueOf(eighth), String.valueOf(ninth), String.valueOf(tenth)};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void DisplayingTheLatestAddedMoviesInReverseOrder() {
        MovieManager manager = new MovieManager();
        manager.add(String.valueOf(first));
        manager.add(String.valueOf(second));
        manager.add(String.valueOf(third));
        manager.add(String.valueOf(fourth));
        manager.add(String.valueOf(fifth));
        manager.add(String.valueOf(sixth));
        manager.add(String.valueOf(seventh));
        manager.add(String.valueOf(eighth));
        manager.add(String.valueOf(ninth));
        manager.add(String.valueOf(tenth));
        String[] actual = manager.finsLast();
        String[] expected = {String.valueOf(tenth), String.valueOf(ninth), String.valueOf(eighth), String.valueOf(seventh), String.valueOf(sixth), String.valueOf(fifth), String.valueOf(fourth), String.valueOf(third), String.valueOf(second), String.valueOf(first)};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void DisplayingTheLatestMoviesAddedInReverseOrderWithALimitSet() {
        manager = new MovieManager(3);
        manager.add(String.valueOf(first));
        manager.add(String.valueOf(second));
        manager.add(String.valueOf(third));

        String[] actual = manager.finsLast();
        String[] expected = {String.valueOf(third), String.valueOf(second), String.valueOf(first)};
        assertArrayEquals(actual, expected);
    }

}