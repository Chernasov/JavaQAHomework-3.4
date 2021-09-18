package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieUnit;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieUnit first = new MovieUnit(1,"https://url.com", "Bloodshote", "Action");
    private MovieUnit second = new MovieUnit(2,"https://url.com", "Forward", "Cartoon");
    private MovieUnit third = new MovieUnit(3,"https://url.com", "Hotel 'Belgrad'", "Comedy");
    private MovieUnit fourth = new MovieUnit(4,"https://url.com", "Gentlemen", "Action");
    private MovieUnit fifth = new MovieUnit(5,"https://url.com", "Invisible man", "Thriller");
    private MovieUnit sixth = new MovieUnit(6,"https://url.com", "Trolly", "Cartoon");
    private MovieUnit seventh = new MovieUnit(7,"https://url.com", "#1", "Comedy");
    private MovieUnit eighth = new MovieUnit(8,"https://url.com", "Duna", "Sci-fi");
    private MovieUnit ninth = new MovieUnit(9,"https://url.com", "Warcraft", "Fantasy");
    private MovieUnit tenth = new MovieUnit(10,"https://url.com", "Evil", "Thriller");
    private MovieUnit eleventh = new MovieUnit(11,"https://url.com", "Heavenly team", "Drama");
    private MovieUnit twelfth = new MovieUnit(12,"https://url.com", "Hero", "Action");
    private MovieUnit thirteenth = new MovieUnit(13,"https://url.com", "After", "Drama");
    private MovieUnit fourteenth = new MovieUnit(14,"https://url.com", "Little horse", "Cartoon");
    private MovieUnit fifteenth = new MovieUnit(15,"https://url.com", "Mask", "Comedy");
    private MovieUnit sixteenth = new MovieUnit(16,"https://url.com", "Ghost", "Drama");


    @Test
    public void shouldAdd (){
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieUnit[] actual = manager.getAll();
        MovieUnit[] expected = new MovieUnit[] {third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastDefaultMovie (){
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);
        manager.add(fourteenth);
        manager.add(fifteenth);
        manager.add(sixteenth);


        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {sixteenth, fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastSetCountMovie (){
        MovieManager manager = new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {eleventh, tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastMovieOverIs (){
        MovieManager manager = new MovieManager(6);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastNullMovie (){
        MovieManager manager = new MovieManager(-2);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {};
        assertArrayEquals(expected, actual);
    }
}