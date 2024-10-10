package library;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Random random = new Random();

        List<String> bookList = Arrays.asList(
                "All you need is kill", "Made in Abyss",
                "Spy x Family", "Jujutsu Kaisen", "Chainsaw Man", "Harry Potter 1",
                "Harry Potter 2", "Harry Potter 3", "Harry Potter 4", "Harry Potter 5"
        );

        List<String> names = Arrays.asList("Илья", "Даниил", "Артем", "Метатрон", "Оптимус Прайм");

        Library library = new Library();

        Collections.shuffle(bookList);
        for (String bookName : bookList) {
            library.addToCatalog(new Book(bookName));
        }

        for(String name : names) {
            Reader reader = new Reader(name);
            library.addReader(reader);
        }

        List<Book> tempLibraryCatalog = new ArrayList<>(library.getCatalog());
        for (Reader reader : library.getReaders()) {

            if (tempLibraryCatalog.size() <= 0) {
                break;
            }

            int booksToGive = random.nextInt(tempLibraryCatalog.size()) + 1;

            for (int i = 0; i < booksToGive && !tempLibraryCatalog.isEmpty(); i++) {

                int bookIndex = random.nextInt(tempLibraryCatalog.size());
                Book book = tempLibraryCatalog.get(bookIndex);

                reader.takeBook(book);
                library.getBook(book.getName());

                tempLibraryCatalog.remove(book);

            }
        }

        System.out.println(library);

    }
}
