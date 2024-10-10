package third;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Clinic {

    private BlockingQueue<Patient> patientsQueue = new LinkedBlockingQueue<>();
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
    }

    public void process() throws InterruptedException {
        while (true) {
            Patient patient = patientsQueue.take();
            therapistAvailableSemaphore.acquire();
            patient.run();

            Thread.sleep(5000);

            therapistAvailableSemaphore.release();
            mrtAvailableSemaphore.acquire();

            System.out.println(String.format("Пациент %d отправился на мрт", patient.getId()));
            Thread.sleep(7500);
            mrtAvailableSemaphore.release();
        }
    }

}
