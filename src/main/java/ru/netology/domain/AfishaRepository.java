package ru.netology.domain;

import ru.netology.domain.MovieUnit;

public class AfishaRepository {
    private MovieUnit[] movies = new MovieUnit[0];

    public void save(MovieUnit movie) {
        int length = movies.length + 1;
        MovieUnit[] tmp = new MovieUnit[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieUnit[] findAll() {
        return movies;
    }

    public void removeById(int id) {
        if (id > movies.length) {return;}
        int length = movies.length - 1;  // определяем длину временного массива на 1 меньше текущего
        MovieUnit[] tmp = new MovieUnit[length]; // создаем временный массив полученной длины
        int index = 0; // вводим переменную для индекса временного массива
        for (MovieUnit movie : movies) {  // для массива movies перебираем по одному
            if (movie.getId() != id) {    // если id в ячейке массива не равно указанному id
                tmp[index] = movie;       //  то переносим данные из  movie во временный архив
                index++;                   // и увеличиваем index на 1
            }
        }
        movies = tmp;                      //  переопределяем массив
    }

    public MovieUnit[] removeAll() {
        MovieUnit[] tmp = new MovieUnit[0];
        movies = tmp;
        return movies;
    }

    public MovieUnit[] findById(int id) {
        MovieUnit[] tmp = new MovieUnit[1];
        for (MovieUnit movie : movies){
            if (movie.getId() == id) {
                tmp[0] = movie;
            }
        }
        return tmp;
    }
}
