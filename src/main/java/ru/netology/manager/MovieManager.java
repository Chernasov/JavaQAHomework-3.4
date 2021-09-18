package ru.netology.manager;

import ru.netology.domain.MovieUnit;

public class MovieManager {
    private MovieUnit[] movies = new MovieUnit[0];
    private int resultLength = 10;

    public MovieManager() {
    }

    public MovieManager(int resultLength) {
        if (resultLength < 0) {
            resultLength = 0;
        }
        this.resultLength = resultLength;
    }

    public void add(MovieUnit movie) {
        int length = movies.length + 1;  // определяем длину временного массива на 1 больше текущего
        MovieUnit[] tmp = new MovieUnit[length]; // создаем временный массив полученной длины
        System.arraycopy(movies, 0, tmp, 0, movies.length); // копируем имеющийся массив во временный полностью
        int lastIndex = tmp.length - 1; // находим номер последнего элемента
        tmp[lastIndex] = movie; // добавляем полученное на входе значение в массив
        movies = tmp; // переопределяем массив
    }

    public MovieUnit[] getAll() {
        MovieUnit[] result = new MovieUnit[movies.length]; // создаем массив с результатом
        for (int i = 0; i < result.length; i++) {  // запускаем перебор массива result по 1 вперед
            int index = movies.length - i - 1;  // рассчитываем значения index в обратном порядке
            result[i] = movies[index];  // заполняем массив result из массива movies в обратном порядке
        }
        return result;
    }

    public MovieUnit[] getLastMovie() {
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

}
