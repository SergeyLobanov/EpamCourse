package epam.test;

/**
 * Created by Сергей on 03.07.2016.
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        PrintByTyme thread1 = new PrintByTyme(1000, 10);
        PrintByTyme thread2 = new PrintByTyme(1500, 8);
        thread1.start();
        thread2.start();
    }
}

class PrintByTyme extends Thread {
    private int milliseconds;
    private int iterations;
    
    public PrintByTyme(int milliseconds, int iterations) {
        this.milliseconds = milliseconds;
        this.iterations = iterations;
    }

    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                sleep(milliseconds);
                System.out.println("Print " + i + " every " + milliseconds);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
