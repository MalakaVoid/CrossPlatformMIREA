package library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private final Map<String, Book> catalogBook;

    private final Map<Integer, Reader> readers;

    public Library() {
        this.catalogBook = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Book getBook(String name) {
        return this.catalogBook.remove(name);
    }

    public void addToCatalog(Book book) {

        this.catalogBook.putIfAbsent(book.getName(), book);
    }

    public void addReader(Reader reader) {
        this.readers.putIfAbsent(reader.getrId(), reader);
    }

    public List<Book> getCatalog() {
        return this.catalogBook.values().stream().toList();
    }

    public List<Reader> getReaders() {
        return this.readers.values().stream().toList();
    }

    @Override
    public String toString() {

        String result = "Книг в библиотеке: " + getCatalog().size() + "\n";

        result += "Доступные книги:\n";
        for (Book book : getCatalog()) {
            result += "\tкнига: " + book.getName() + "\n";
        }

        result += "Колличество читателей: " + getReaders().size() + "\n";

        result += "Читатели:\n";
        int takenBooks = 0;
        for (Reader reader : getReaders()) {
            takenBooks += reader.getTakenBooks().size();
            result += "\tчитатель: " + reader.getName() + " кол-во книг: " + reader.getTakenBooks().size() + "\n";
        }

        result += "Книг у читателей всего: " + takenBooks;

        return result;
    }

}