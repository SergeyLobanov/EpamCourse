package task3.transport;

/**
 * Created by Сергей on 20.05.2016.
 */
public class Motorcycle extends Vehicle{

    public Motorcycle(){}

    public Motorcycle(Manufacture manufacture, String number) {
        super(manufacture, number);
    }

    @Override
    public void ride() {
        System.out.println("Motorcycle ride");
    }

}
