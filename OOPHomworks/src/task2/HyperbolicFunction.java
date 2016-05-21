package task2;

/**
 * class represents hyperbolic function in canonical form
 * Created by Сергей on 20.05.2016.
 */
public class HyperbolicFunction extends Function implements Cloneable {
    /**
     * general canonical form of hyperbola is
     *  (x^2)/(a^2) - (y^2)/(b^2) = 1
     */
    /**
     * a coefficient of hyperbolic function
     */
    private double aCoefficient;
    /**
     * b coefficient of hyperbolic function
     */
    private double bCoefficient;
    /**
     * distance for focuses
     */
    private double cCoefficient;
    /**
     * first focus
     */
    private Point focus1;
    /**
     * second focus
     */
    private Point focus2;
    /**
     * eccentricity of hyperbola
     */
    private double eccentricity;

    /**
     * constructor of hyperbolic function by a and b coefficients
     */
    public HyperbolicFunction(double aCoefficient, double bCoefficient) {
        this.aCoefficient = aCoefficient;
        this.bCoefficient = bCoefficient;
        this.cCoefficient = calculateCCoefficient();
        this.eccentricity = calculateEccentricity();
        this.focus1 = new Point(cCoefficient, 0);
        this.focus2 = new Point(-cCoefficient, 0);
    }

    /**
     * constructor of hyperbolic function by focus point and eccentricity
     */
    public HyperbolicFunction(Point focus, double eccentricity) {
        this.eccentricity = eccentricity;
        cCoefficient = Math.abs(focus.getX());
        this.focus1 = new Point(cCoefficient, 0);
        this.focus2 = new Point(-cCoefficient, 0);
        this.aCoefficient = calculateACoefficient();
        this.bCoefficient = calculateBCoefficient();
    }

    public Point getFocus1() {
        return focus1;
    }

    public Point getFocus2() {
        return focus2;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public double getACoefficient() {
        return aCoefficient;
    }

    //when we change a coefficient other parameters are changing
    public void setACoefficient(double aCoefficient) {
        this.aCoefficient = aCoefficient;
        this.cCoefficient = calculateCCoefficient();
        this.eccentricity = calculateEccentricity();
        this.focus1.setX(cCoefficient);
        this.focus2.setX(-cCoefficient);
    }

    public double getBCoefficient() {
        return bCoefficient;
    }

    //when we change b coefficient other parameters are changing
    public void setBCoefficient(double bCoefficient) {
        this.bCoefficient = bCoefficient;
        this.cCoefficient = calculateCCoefficient();
        this.eccentricity = calculateEccentricity();
        this.focus1.setX(cCoefficient);
        this.focus2.setX(-cCoefficient);
    }

    public double getCCoefficient() {
        return cCoefficient;
    }

    @Override
    public double getXbyY(double yCoordinate) {
        return Math.sqrt(Math.pow(aCoefficient, 2)*(Math.pow(yCoordinate, 2)
                / Math.pow(bCoefficient, 2) + 1));
    }

    @Override
    public double getYbyX(double xCoordinate) {
        return Math.sqrt(Math.pow(aCoefficient, 2)*(Math.pow(xCoordinate, 2)
                / Math.pow(bCoefficient, 2) - 1));
    }

    private double calculateACoefficient() {
        return cCoefficient/eccentricity;
    }

    private double calculateBCoefficient() {
        return Math.sqrt(Math.pow(cCoefficient,2)
                - Math.pow(aCoefficient,2));
    }

    private double calculateCCoefficient() {
        return Math.sqrt((Math.pow(aCoefficient,2))
                + (Math.pow(bCoefficient,2)));
    }

    private double calculateEccentricity() {
        return cCoefficient/aCoefficient;
    }

    @Override
    public HyperbolicFunction clone()  {
        Point cloneFocus = focus1.clone();
        return new HyperbolicFunction(cloneFocus , eccentricity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HyperbolicFunction that = (HyperbolicFunction) o;

        if (Double.compare(that.aCoefficient, aCoefficient) != 0) return false;
        return Double.compare(that.bCoefficient, bCoefficient) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(aCoefficient);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bCoefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "HyperbolicFunction {" +
                "x^2/" + Math.pow(aCoefficient,2) +
                " - y^2/" + Math.pow(bCoefficient,2) +
                " = 1, eccentricity " + eccentricity +
                " and focuses F1 " + focus1 +
                "; F2 " + focus2 +
                '}';
    }
}
