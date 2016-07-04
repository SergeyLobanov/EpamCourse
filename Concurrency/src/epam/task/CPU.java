package epam.task;

/**
 * Created by Сергей on 03.07.2016.
 */
public class CPU extends Thread {
    /**
     * queues of processes for service
     */
    private CPUQueue firstQueue;
    private CPUQueue secondQueue;
    /**
     * range to generate time of serve for processes
     */
    private long lowTimeValue;
    private long highTimeValue;
    /**
     * value of served processes from first queue
     * before cpu serves process from second queue
     */
    private int fromFirstQueueN;

    public CPU(long lowTimeValue, long highTimeValue, int fromFirstQueueN) {
        this.lowTimeValue = lowTimeValue;
        this.highTimeValue = highTimeValue;
        this.fromFirstQueueN = fromFirstQueueN;
    }

    @Override
    public void run() {
        try {
            int serveCounter = 1;
            while(true) {
                long serveTime = (long) (lowTimeValue + (highTimeValue - lowTimeValue + 1) * Math.random());
                if (serveCounter % fromFirstQueueN != 0) {
                    firstQueue.pop();
                } else {
                    secondQueue.pop();
                }
                serveCounter++;
                //System.out.println("cpu k " + serveCounter);
                secondQueue.checkSize();
                if (!Thread.currentThread().isInterrupted()) {
                    sleep(serveTime);
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("finished");
            //ie.printStackTrace();
        }
        }

    public void setFirstQueue(CPUQueue firstQueue) {
        this.firstQueue = firstQueue;
    }

    public void setSecondQueue(CPUQueue secondQueue) {
        this.secondQueue = secondQueue;
    }
}
