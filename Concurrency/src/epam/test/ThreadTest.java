package epam.test;

/**
 * Created by Сергей on 03.07.2016.
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass("thread1");
        threadClass.start();

        AnotherThreadClass anotherThreadClass = new AnotherThreadClass("thread2");
        anotherThreadClass.start();
    }
}

class ThreadClass extends Thread {
    public ThreadClass(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sleep(1000);
                System.out.println("ThreadClass " + i + " " + System.nanoTime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class AnotherThreadClass extends Thread {

    public AnotherThreadClass(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 7; i++) {
                sleep(1500);
                System.out.println("AnotherThreadClass " + i + " " + System.nanoTime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
