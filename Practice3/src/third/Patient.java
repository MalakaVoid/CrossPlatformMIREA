package third;

public class Patient implements Runnable {

    private int id;

    public Patient(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        System.out.println(String.format("Пациент %d отправился к терапевту", id));
    }

}
