package task2;

/**
 * Created by Сергей on 20.05.2016.
 */
public abstract class Function {

    /**
     * calculate value of X coordinate for corresponding
     * @param yCoordinate coordinate
     * @return X coordinates
     */
    public abstract double getXbyY(double yCoordinate);

    /**
     * calculate value of Y coordinate for corresponding
     * @param xCoordinate coordinate
     * @return Y coordinates
     */
    public abstract double getYbyX(double xCoordinate);

}
