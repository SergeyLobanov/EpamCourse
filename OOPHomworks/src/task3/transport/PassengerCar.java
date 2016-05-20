package task3.transport;

/**
 * Created by Сергей on 20.05.2016.
 */
public class PassengerCar extends Vehicle {

    public PassengerCar(){}

    public PassengerCar(Manufacture manufacture, String number) {
        super(manufacture, number);
    }

    @Override
    public void ride() {
        System.out.println("Passenger car ride");
    }
}
