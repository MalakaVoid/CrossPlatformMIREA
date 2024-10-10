package first;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Thread writerClassThread = new Thread(new Writer(listOfNumbers));
        Thread readerClassThread = new Thread(new Reader(listOfNumbers));

        writerClassThread.start();
        readerClassThread.start();
    }
}