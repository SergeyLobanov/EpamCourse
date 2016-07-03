package epam.arraysum;

/**
 * Created by Сергей on 03.07.2016.
 */
public class SumThreadMain {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 7, 4, 13, 3, 9, 5, 2, 8, 22, 9, 6, 7};
        SumThread sumThread1 = new SumThread(array, 0, array.length/2);
        SumThread sumThread2 = new SumThread(array, array.length/2, array.length);
        sumThread1.start();
        sumThread2.start();
        sumThread1.join();
        sumThread2.join();
        System.out.println("Array sum = " +  (sumThread1.getArraySum() + sumThread2.getArraySum()));
    }
}
class SumThread extends Thread {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int arraySum;

    public SumThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            arraySum += array[i];
        }
        System.out.println("sum from " + startIndex + " to " + endIndex + "" +
                " = " + arraySum);
    }

    public int getArraySum() {
        return arraySum;
    }
}
