package Db;

import java.util.ArrayList;

public class ParkingSlot {
    public static ArrayList<Integer> vanParking = new ArrayList();
    public static ArrayList<Integer> cargoLorryParking = new ArrayList();
    public static ArrayList<Integer> BusParking = new ArrayList();

    static {

//        Parking slots 1,2,3,4,13 and 12 are reserved for vans.
        vanParking.add(1);
        vanParking.add(2);
        vanParking.add(3);
        vanParking.add(4);
        vanParking.add(12);
        vanParking.add(13);

//        Cargo Lorry --> 5 to 11
        cargoLorryParking.add(5);
        cargoLorryParking.add(6);
        cargoLorryParking.add(7);
        cargoLorryParking.add(8);
        cargoLorryParking.add(9);
        cargoLorryParking.add(10);
        cargoLorryParking.add(11);


//        Slot number 14 is reserved for the employee transportation bus of the company.
        BusParking.add(14);
    }
}
