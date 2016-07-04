package epam.task;

/**
 * Created by Сергей on 03.07.2016.
 */
public class CPUProcess extends Thread {
    /**
     * queue that store generated by CPUProcess processes
     */
    private CPUQueue cpuQueue;
    /**
     * range to generate time of creating for processes
     */
    private long lowTimeValue;
    private long highTimeValue;
    /**
     * number of destroyed processes
     */
    private int counterOfDestroyedProcesses;
    /**
     * number of generated processes by all CPUProcesses
     */
    private static int counterOfGeneratedProcesses;

    public CPUProcess(CPUQueue cpuQueue, long lowTimeValue, long highTimeValue) {
        this.cpuQueue = cpuQueue;
        this.lowTimeValue = lowTimeValue;
        this.highTimeValue = highTimeValue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                long serveTime = (long)(lowTimeValue + (highTimeValue - lowTimeValue + 1)
                        * Math.random());//random time number between low and high values
                Process process = new Process();
                counterOfGeneratedProcesses++;
                if (cpuQueue.getSize() < cpuQueue.getMaxSize()) {
                    cpuQueue.push(process);
                } else {
                    process = null;
                    counterOfDestroyedProcesses++;
                }
                //System.out.println("proc k " + k++);
                sleep(serveTime);
            }
        } catch (InterruptedException ie) {
            System.out.println("finished");
            //ie.printStackTrace();
        }
    }

    public int getCounterOfDestroyedProcesses() {
        return counterOfDestroyedProcesses;
    }

    public static int getCounterOfGeneratedProcesses() {
        return counterOfGeneratedProcesses;
    }
}
