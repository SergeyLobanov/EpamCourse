package epam.task;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Сергей on 03.07.2016.
 */
public class CPUQueue<T> {
    private LinkedList<T> list; //todo: contain process?
    private int maxSize;
    private static int maxSizeOfSecondQueue;
    private static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    public CPUQueue(int maxSize){
        this.list = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public CPUQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public synchronized void push(T process) {
        //todo: verify in process?
        //
        /*while( list.size() >= maxSize ){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CPUQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        list.add(process);
        notify();

    }

    public synchronized T pop(){
        while( list.size() == 0 ){
            try {
                wait();
            } catch (InterruptedException ex) {
                //todo: check it later
                Logger.getLogger(CPUQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        T temp = list.pop();
        notify();
        return temp;
    }

    //todo: make daemon?
    public void checkSize(){
        if (getSize() > maxSizeOfSecondQueue) {
            maxSizeOfSecondQueue = getSize();
        }
    }

    public int getSize() {
        return list.size();
    }

    public int getMaxSize(){
        return maxSize;
    }

    public static int getMaxSizeOfSecondQueue() {
        return maxSizeOfSecondQueue;
    }
}
