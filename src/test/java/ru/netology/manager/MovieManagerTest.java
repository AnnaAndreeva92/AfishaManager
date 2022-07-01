package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {


    Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    Movie second = new Movie(2, "Forward", "http://", "cartoon");
    Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    Movie sixth = new Movie(6, "Trolls.WorldTour", "http://", "cartoon");
    Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    Movie eighth = new Movie(8, "DreamMakers", "http://", "animation");
    Movie ninth = new Movie(9, "Missing", "http://", "thriller");
    Movie tenth = new Movie(10, "RocketScientist", "http://", "drama");


    @Test
    public void addMovie() {
        MovieManager manager = new MovieManager(5);
        manager.add("first");
        manager.add("second");
        manager.add("third");
        manager.add("fourth");

        Movie newMovie = new Movie(10,"threeСats","http://","cartoon" );
        manager.add(String.valueOf(newMovie));
        String[] actual = manager.findAll();
        String[] expected = {"first","second","third", "fourth", String.valueOf(new Movie(10,"threeСats","http://","cartoon" ))};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void ListAllMoviesInTheOrderTheyWereAdded() {
        MovieManager manager = new MovieManager(10);
        manager.add("first");
        manager.add("second");
        manager.add("third");
        manager.add("fourth");
        manager.add("fifth");
        manager.add("sixth");
        manager.add("seventh");
        manager.add("eighth");
        manager.add("ninth");
        manager.add("tenth");

        String[] actual = manager.findAll();
        String[] expected = {"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void DisplayingTheLatestAddedMoviesInReverseOrder() {
        MovieManager manager = new MovieManager(10);
        manager.add("first");
        manager.add("second");
        manager.add("third");
        manager.add("fourth");
        manager.add("fifth");
        manager.add("sixth");
        manager.add("seventh");
        manager.add("eighth");
        manager.add("ninth");
        manager.add("tenth");
        String[] actual = manager.finsLast();
        String[] expected = {"tenth","ninth","eighth","seventh","sixth","fifth","fourth","third","second","first"};
        assertArrayEquals(actual, expected);
    }
    @Test
    void mustShowNothing() {
        MovieManager manager = new MovieManager(0);
        String[] actual = manager.finsLast();
        String[] expected = new String[0];
        assertArrayEquals(expected, actual);
    }
    @Test
    void mustShowOverMax() {
        MovieManager manager = new MovieManager(11);
        manager.add("first");
        manager.add("second");
        manager.add("third");
        manager.add("fourth");
        manager.add("fifth");
        manager.add("sixth");
        manager.add("seventh");
        manager.add("eighth");
        manager.add("ninth");
        manager.add("tenth");
        String[] expected = {"tenth","ninth","eighth","seventh","sixth","fifth","fourth","third","second","first"};
        String[] actual = manager.finsLast();
        assertArrayEquals(expected, actual);

    }
}