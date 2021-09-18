package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaRepository;
import ru.netology.domain.MovieUnit;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();
    private MovieUnit first = new MovieUnit(1,"https://url.com", "Bloodshote", "Action");
    private MovieUnit second = new MovieUnit(2,"https://url.com", "Forward", "Cartoon");
    private MovieUnit third = new MovieUnit(3,"https://url.com", "Hotel 'Belgrad'", "Comedy");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldRepositoryRemoveByIdWithin() {
        int idToRemove = 2;
        repository.removeById(idToRemove);

        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[] {first, third};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRepositoryRemoveByIdOver() {
        int idToRemove = 4;
        repository.removeById(idToRemove);

        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[] {first, second, third};
        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldRepositoryRemoveAll() {
        repository.removeAll();

        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[] {};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRepositoryFindById() {
        int idToFind = 2;

        MovieUnit[] actual = repository.findById(idToFind);
        MovieUnit[] expected = new MovieUnit[] {second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryFindByIdOver() {
        int idToFind = 4;

        MovieUnit[] actual = repository.findById(idToFind);
        MovieUnit[] expected = new MovieUnit[] {null};
        assertArrayEquals(expected, actual);
    }
}