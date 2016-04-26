/**
 * Created by Сергей on 26.04.2016.
 */
public class AverageNumber {
    private int numberA;
    private int numberB;
    private int numberC;

    public AverageNumber(int numberA, int numberB, int numberC) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.numberC = numberC;
    }

    public double calculateAverage(){
        return (numberA + numberB + numberC)/3.;
    }

    public int roundAderage(){
        return (int)Math.round(calculateAverage());
    }

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public int getNumberB() {
        return numberB;
    }

    public void setNumberB(int numberB) {
        this.numberB = numberB;
    }

    public int getNumberC() {
        return numberC;
    }

    public void setNumberC(int numberC) {
        this.numberC = numberC;
    }
}
