package first;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer implements Runnable {

    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            listOfNumbers.add(random.nextInt(5000));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
