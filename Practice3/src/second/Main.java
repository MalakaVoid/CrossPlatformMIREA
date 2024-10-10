package second;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        
        int personAmount = 10;
        Thread[] personsThreads = new Thread[personAmount];
        String[] personsCategories = new String[]{"Молодой", "Старый", "Бизнесмен"};

        MFC mfc = new MFC();
        for (int i = 0; i < personAmount; i++) {
            String category = personsCategories[random.nextInt(personsCategories.length)];
            personsThreads[i] = new Thread(new Person(category, mfc));
            personsThreads[i].start();
        }

        for (Thread thread : personsThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        mfc.printLeaves(personAmount);
    }
}
