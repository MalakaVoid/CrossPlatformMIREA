package first;

import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable {

    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }


    @Override
    public void run() {
        for (int i = 1; i < 15; i++){
            for (Integer num : listOfNumbers) {
                System.out.println("Число " + num);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
