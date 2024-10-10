package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MFC {

    private Window[] windows = new Window[3];
    private ArrayList<Integer> gone = new ArrayList<>();

    public MFC() {
        for (int i = 0; i < windows.length; i++) {
            windows[i] = new Window();
        }
        gone = new ArrayList<>(Arrays.asList(0,0,0));
    }

    public boolean visit(Person person) {

        Random random = new Random();
        int windowIndex = random.nextInt(windows.length);
        if (windows[windowIndex].isBusy) {
            return false;
        }

        if (canServePerson(person, windowIndex)) {
            windows[windowIndex].isBusy = true;
            return true;
        }

        return false;

    }

    private boolean canServePerson(Person person, int windowIndex) {

        if (windowIndex == 0) {
            return true;
        }
        else if (windowIndex == 1 && person.getCategory().equals("Старый")) {
            return true;
        }
        else if (windowIndex == 2 && person.getCategory().equals("Бизнесмен")) {
            return true;
        }

        return false;
    }

    public void leaveWindow() {
        for (Window window : windows) {
            window.isBusy = false;
        }
    }

    public void addGone(String cat) {

        if (cat.equals("Молодой")) {
            gone.set(0, gone.get(0) + 1);
        }
        else if (cat.equals("Старый")) {
            gone.set(1, gone.get(1) + 1);
        }
        else if (cat.equals("Бизнесмен")) {
            gone.set(2, gone.get(2) + 1);
        }

    }

    public void printLeaves(int personsAmount) {
        System.out.println(
            "Ушло:\n" +
            "\tМолодой " + (gone.get(0) * 100 / personsAmount) + "%\n" +
            "\tСтарый " + (gone.get(1) * 100 / personsAmount) + "%\n" +
            "\tБизнесмен " + (gone.get(2) * 100 / personsAmount) + "%"
        );
    }

}
