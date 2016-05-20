package task3.transport;

/**
 * Created by Сергей on 20.05.2016.
 */
public class Truck extends Vehicle {

    public Truck(){}

    public Truck(Manufacture manufacture, String number) {
        super(manufacture, number);
    }

    @Override
    public void ride() {
        System.out.println("Truck ride");
    }
}
