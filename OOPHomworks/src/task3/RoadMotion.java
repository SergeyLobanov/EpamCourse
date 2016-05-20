package task3;

import task3.transport.Manufacture;
import task3.transport.Vehicle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 20.05.2016.
 */
public class RoadMotion {
    /**
     * list of vehicle that have ridden here
     */
    private List<Vehicle> vehicles;

    public RoadMotion() {
        vehicles = new LinkedList<>();
    }

    /**
     * add vehicle to list of ridden transport through road
     * @param trans that have ridden
     * @return result of addition
     */
    public boolean addVehicle(Vehicle trans) {
        boolean added = false;
        if (trans == null || vehicles.contains(trans)) {
            return false;
        }
        vehicles.add(trans);
        return true;
    }

    /**
     * count number of vehicles with same class of argument in list
     * @param trans set class that will have founded
     * @return number of vehicle with same class
     */
    public int countVehicleOfType(Vehicle trans) {
        int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == trans.getClass()) {
                count++;
            }
        }
        return count;
    }

    /**
     * check is the vehicle of trans class of manufacture factory with number had ridden through road
     * @param trans set class of searched vehicle
     * @param manufacture of vehicle
     * @param number of vehicle
     * @return result of search
     */
    public boolean isModelHadRidden(Vehicle trans, Manufacture manufacture, String number){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == trans.getClass()
                    && vehicle.getManufacture() == manufacture
                    && vehicle.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    public List<Vehicle> getTransports() {
        return vehicles;
    }
}
