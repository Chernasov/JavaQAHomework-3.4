package ru.netology.manager;

import ru.netology.domain.AfishaRepository;
import ru.netology.domain.MovieUnit;

public class AfishaManager {
    private AfishaRepository repository;
    private int resultLength = 10;


    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int resultLength) {
        this.repository = repository;
        if (resultLength < 0) {
            resultLength = 0;
        }
        this.resultLength = resultLength;
    }

    public void add(MovieUnit movie) {
        repository.save(movie);
    }

    public MovieUnit[] getAll() {
        MovieUnit[] movies = repository.findAll();  // создаем копию репозитория
        MovieUnit[] result = new MovieUnit[movies.length]; // создаем массив с результатом
        for (int i = 0; i < result.length; i++) {  // запускаем перебор массива result по 1 вперед
            int index = movies.length - i - 1;  // рассчитываем значения index в обратном порядке
            result[i] = movies[index];  // заполняем массив result из массива movies в обратном порядке
        }
        return result;
    }

    public MovieUnit[] getLastMovie() {
        MovieUnit[] movies = repository.findAll();  // создаем копию репозитория
        if (movies.length < resultLength) {  // сравниваем длину массива movies с заданной длиной массива
            resultLength = movies.length;   // если длина массива movies меньше чем заданная, то уменьшаем заданную длину
        }
        MovieUnit[] result = new MovieUnit[resultLength]; //создаем массив длиной resultLength
        for (int i = 0; i < result.length; i++) {  // запускаем перебор массива result по 1 вперед
            int index = movies.length - i - 1;  // рассчитываем значения index в обратном порядке
            result[i] = movies[index];  // заполняем массив result из массива movies в обратном порядке
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public MovieUnit[] findById(int id) {
        MovieUnit[] find = new MovieUnit[1];
        find = repository.findById(id);
        return find;
    }
}
