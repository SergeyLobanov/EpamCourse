package task3.transport;

/**
 * Created by Сергей on 20.05.2016.
 */
public abstract class Vehicle implements Transport{
    /**
     * cars manufacture
     */
    protected Manufacture manufacture;
    /**
     * number of car
     */
    protected String number;

    Vehicle(){}

    Vehicle(Manufacture manufacture, String number){
        this.manufacture = manufacture;
        this.number = number;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public String getNumber(){
        return number;
    }
}
