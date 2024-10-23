package third;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Clinic {

    private BlockingQueue<Patient> patientsQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<Patient> mrtQueue = new LinkedBlockingQueue<>();
    private Semaphore therapistAvailableSemaphore = new Semaphore(1);
    private Semaphore mrtAvailableSemaphore = new Semaphore(1);

    private int maxQueueLength = 0;

    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    public void addPatient(Patient patient) {
        patientsQueue.offer(patient);
        changeMaxQueueLength();
    }

    private void changeMaxQueueLength() {
        maxQueueLength = Math.max(patientsQueue.size(), maxQueueLength);
        maxQueueLength = Math.max(mrtQueue.size(), maxQueueLength);
    }

    public void process() throws InterruptedException {

        Thread therapistThread = new Thread(() -> {
            try {
                while (true) {
                    Patient patient = patientsQueue.take();
                    therapistAvailableSemaphore.acquire();
                    patient.run();
                    Thread.sleep(5000);
                    System.out.println(String.format("Пациент %d закончил приём у терапевта", patient.getId()));
                    therapistAvailableSemaphore.release();


                    mrtQueue.put(patient);
                    changeMaxQueueLength();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread mrtThread = new Thread(() -> {
            try {
                while (true) {
                    mrtAvailableSemaphore.acquire();
                    Patient patient = mrtQueue.take();
                    System.out.println(String.format("Пациент %d отправился на МРТ", patient.getId()));
                    Thread.sleep(7500);
                    System.out.println(String.format("Пациент %d закончил обследование на МРТ", patient.getId()));
                    mrtAvailableSemaphore.release();

                    System.out.println(String.format("Максимальная очередь %d человек", getMaxQueueLength()));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        therapistThread.start();
        mrtThread.start();

        therapistThread.join();
        mrtThread.join();
    }

}
