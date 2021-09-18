package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.AfishaRepository;
import ru.netology.domain.MovieUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
//    @Mock
    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);
//    @InjectMocks

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

    @Test
    public void shouldAdd() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();
        AfishaManager manager = new AfishaManager(repository);
        manager.add(first);
        MovieUnit[] actual = manager.getAll();
        MovieUnit[] expected = new MovieUnit[] {third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).save(first);
    }

    @Test
    void shouldGetLastDefaultMovie() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();
        AfishaManager manager = new AfishaManager(repository);
        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastSetCountMovie() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,1);
        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMovieOverIs() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,5);
        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastNullMovie() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,-1);
        MovieUnit[] actual = manager.getLastMovie();
        MovieUnit[] expected = new MovieUnit[] {};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveById() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();
        AfishaManager manager = new AfishaManager(repository);

        int idToRemove = 2;
        manager.removeById(idToRemove);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldRemoveAll() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();
        AfishaManager manager = new AfishaManager(repository);

        manager.removeAll();
        verify(repository).removeAll();
    }

    @Test
    void shouldFindById() {
        MovieUnit[] returned = new MovieUnit[] {first, second, third};
        doReturn(returned).when(repository).findAll();
        AfishaManager manager = new AfishaManager(repository);

        int idToFind = 2;
        MovieUnit[] actual = manager.findById(idToFind);
        verify(repository).findById(idToFind);


    }
}