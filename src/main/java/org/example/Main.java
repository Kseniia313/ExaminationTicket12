package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Задача
//        Необходимо реализовать следующий метод:
//
//        На вход получаем список названий книг.
//        Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
//        Все книги должны быть отсортированы по алфавиту с первой до последней полки.
//        Количество полок константное — 5 штук.
//        Вернуть книги, распределенные по полкам.
public class Main {

    public static List<List<String>> sortedBook(List<String> books) {

        books = books.stream().sorted().collect(Collectors.toList());

        int totalBooks = books.size();

        int bookPerShelf = (int) Math.ceil((double) totalBooks / 5);

        List<List<String>> shelves = new ArrayList<>();
        for (int i=0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }

        int currentShelf = 0;
        for (String book : books) {
            shelves.get(currentShelf).add(book);
            if (shelves.get(currentShelf).size() >= bookPerShelf) {
                currentShelf++;
            }
        }
        return shelves;
    }


    public static void main(String[] args) {
        List<String> books = List.of(
                "Anna Karenina", "Voina i Mir",
                "Otci i deti", "More", "Pirati",
                "Prostokvashino","Durak", "Idiot"
        );

        List<List<String>> shelves = sortedBook(books);

        int shelfNumber = 1;
        for (List<String> shelf : shelves) {
            System.out.println("Shelf " + shelfNumber + ": " + shelf);
            shelfNumber++;
        }
    }
}


