package task3;

import task3.transport.*;

/**
 * Created by Сергей on 20.05.2016.
 */
public class Crossroad {
    public static void main(String[] args) {
        RoadMotion roadMotion = new RoadMotion();
        roadMotion.addVehicle(new Motorcycle(Manufacture.YAMAHA, "AA 111-11 A"));
        roadMotion.addVehicle(new PassengerCar(Manufacture.AUDI, "AA 1234 AA"));
        roadMotion.addVehicle(new Truck(Manufacture.MERCEDES, "AK 4267 KN"));
        roadMotion.addVehicle(new Truck(Manufacture.TOYOTA, "CP 1315 PP"));
        roadMotion.addVehicle(new Motorcycle(Manufacture.YAMAHA, "CA 234-34 B"));

        System.out.println(roadMotion.countVehicleOfType(new Truck()));
        System.out.println(roadMotion.isModelHadRidden(new Motorcycle(), Manufacture.YAMAHA, "CA 234-34 B"));
    }
}
