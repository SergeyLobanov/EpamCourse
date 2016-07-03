package epam.test;

/**
 * Created by Сергей on 03.07.2016.
 */
public class RunnableTest {
    public static void main(String[] args) {
        RunnableClass runnable = new RunnableClass(750, "first");
        Thread thread = new Thread(runnable);
        thread.start();

        //System.out.println(thread.isAlive());//true

        RunnableClass runnable1 = new RunnableClass(500, "second");
        Thread thread1 = new Thread(runnable1);
        thread1.start();


        //getPriority
        //System.out.println(thread.getPriority());//5
        //System.out.println(thread1.getPriority());//5
        //thread.setPriority(1); //priority is on involves on threads cause sleep()
        //thread1.setPriority(10);


        try {
            thread.join();
            //System.out.println(thread1.isAlive());//false
            thread1.join();
            //System.out.println(thread1.isAlive());//false
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Main thread");
    }
}

class RunnableClass implements Runnable {
    private int timer;
    private String name;

    public RunnableClass(int timer, String name) {
        this.timer = timer;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
            Thread.sleep(timer);
            System.out.println(name + " " + i);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
