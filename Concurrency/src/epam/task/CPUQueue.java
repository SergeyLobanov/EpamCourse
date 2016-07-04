package epam.task;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Сергей on 03.07.2016.
 */
public class CPUQueue {
    private LinkedList list;
    private int maxSize;
    private int maxWorkSizeOfQueue;
    private static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    public CPUQueue(int maxSize){
        this.list = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public CPUQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public synchronized void push(Object process) {
        list.add(process);
        notify();
    }

    public synchronized Object pop(){
        while( list.size() == 0 ){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CPUQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Object temp = list.pop();
        notify();
        return temp;
    }

    public void checkSize(){
        if (getSize() > maxWorkSizeOfQueue) {
            maxWorkSizeOfQueue = getSize();
        }
    }

    public int getSize() {
        return list.size();
    }

    public int getMaxSize(){
        return maxSize;
    }

    public int getMaxWorkSizeOfQueue() {
        return maxWorkSizeOfQueue;
    }
}
