package epam.task;

/**
 * Created by Сергей on 04.07.2016.
 */
public class Process {
    /**
     * id of process
     */
    private int processID;
    public static int id = 0;

    public Process() {
        this.processID = id++;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

}
