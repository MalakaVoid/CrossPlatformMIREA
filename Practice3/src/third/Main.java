package third;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Clinic clinic = new Clinic();
        Thread clinicThread = new Thread(() -> {
            try {
                clinic.process();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        clinicThread.start();

        for (int i = 0; i < 10; i++) {
            Patient patient = new Patient(i);
            clinic.addPatient(patient);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            clinicThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("Макимальная очередь %d", clinic.getMaxQueueLength()));
    }
}
