package epam.task;

/**
 * Created by Сергей on 03.07.2016.
 */
public class Runner {
    public static int N_FROM_FIRST_QUEUE = 5;
    public static int FIRST_QUEUE_MAX_SIZE = 3;
    public static void main(String[] args) throws InterruptedException {
        CPUQueue cpuQueue1 = new CPUQueue(FIRST_QUEUE_MAX_SIZE);
        CPUQueue cpuQueue2 = new CPUQueue();
        CPUProcess cpuProcess1 = new CPUProcess(cpuQueue1, 200, 400); //todo: controller
        CPUProcess cpuProcess2 = new CPUProcess(cpuQueue2, 300, 450);
        CPU cpu = new CPU(400, 700, N_FROM_FIRST_QUEUE);

        cpu.setFirstQueue(cpuQueue1);
        cpu.setSecondQueue(cpuQueue2);


        cpuProcess1.start();
        cpuProcess2.start();
        cpu.start();

        try {
            cpuProcess1.join();
            cpuProcess2.join();
            cpu.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        //Thread.sleep(100500);
        System.out.println(//"Percent of destroyed processes" +
                /*+(double)*/cpuProcess1.getCounterOfDestroyedProcesses());
                 //CPUProcess.getCounterOfGeneratedProcesses()*100 + " %");
        System.out.println("Max size of second deque " + CPUQueue.getMaxSizeOfSecondQueue());
    }
}
