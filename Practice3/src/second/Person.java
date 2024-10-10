package second;

public class Person implements Runnable {

    private final String category;
    private final MFC mfc;

    public Person(String category, MFC mfc) {
        this.category = category;
        this.mfc = mfc;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void run() {
        if (mfc.visit(this)) {

            System.out.println(String.format("Гражданин %s обслуживается", category));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            mfc.leaveWindow();
            System.out.println(String.format("Гражданин %s ушел", category));

        } else {

            System.out.println(String.format("Гражданин %s не у того окна", category));
            mfc.addGone(category);

        }
    }
}
