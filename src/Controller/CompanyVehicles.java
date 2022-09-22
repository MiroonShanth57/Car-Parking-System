package Controller;

import java.util.ArrayList;

public class CompanyVehicles {
    private String date;

    private String vehicleNumber = null;
    private String vehicleType = null;
    private int maximumWeight = 0;
    private int numOfPassengers = 0;

    private String driverNIC = null;
    private String driverName;

    private String vehicleParkedSlot = null;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleParkedSlot() {
        return vehicleParkedSlot;
    }

    public void setVehicleParkedSlot(String vehicleParkedSlot) {
        this.vehicleParkedSlot = vehicleParkedSlot;
    }

    public static ArrayList<CompanyVehicles> getAllVehicleArrayList() {
        return AllVehicleArrayList;
    }

    public static void setAllVehicleArrayList(ArrayList<CompanyVehicles> allVehicleArrayList) {
        AllVehicleArrayList = allVehicleArrayList;
    }

    public static ArrayList<CompanyVehicles> getParkedVehicles() {
        return parkedVehicles;
    }

    public static void setParkedVehicles(ArrayList<CompanyVehicles> parkedVehicles) {
        CompanyVehicles.parkedVehicles = parkedVehicles;
    }

    public static ArrayList<CompanyVehicles> getOnShiftVehicles() {
        return onShiftVehicles;
    }

    public static void setOnShiftVehicles(ArrayList<CompanyVehicles> onShiftVehicles) {
        CompanyVehicles.onShiftVehicles = onShiftVehicles;
    }

    @Override
    public String toString() {
        return vehicleNumber ;
    }


//    ////////////////////////////////////////////////////////////////////////////////////////

    public CompanyVehicles(String vehicleNumber, String date, String driverName, String vehicleType) {
        this.date = date;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
    }

    public CompanyVehicles(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String vehicleParkedSlot) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
        this.vehicleParkedSlot = vehicleParkedSlot;
    }

    public CompanyVehicles(String date, String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNIC, String vehicleParkedSlot) {
        this.date = date;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
        this.driverNIC = driverNIC;
        this.vehicleParkedSlot = vehicleParkedSlot;
    }


//extends Class's ==========================================

//    Bus Class
    public static class Bus extends CompanyVehicles {
        public Bus(String vehicleNumber, String date, String driverName, String vehicleType) {
            super(vehicleNumber,date,driverName,vehicleType);
        }

        public Bus(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String vehicleParkedSlot) {
            super(vehicleNumber, vehicleType, maximumWeight, numOfPassengers,vehicleParkedSlot);
        }

        public Bus(String date, String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNIC, String vehicleParkedSlot) {
            super(date, vehicleNumber, vehicleType, maximumWeight, numOfPassengers, driverNIC, vehicleParkedSlot);
        }
    }


//    Van Class
    public static class Van extends CompanyVehicles{
        public Van(String vehicleNumber, String date, String driverName, String vehicleType) {
            super(vehicleNumber,date,driverName,vehicleType);
        }

        public Van(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String vehicleParkedSlot) {
            super(vehicleNumber, vehicleType, maximumWeight, numOfPassengers,vehicleParkedSlot);
        }

        public Van(String date, String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNIC, String vehicleParkedSlot) {
            super(date, vehicleNumber, vehicleType, maximumWeight, numOfPassengers, driverNIC, vehicleParkedSlot);
        }
    }


//    Cargo Lorry Class
    public static class CargoLorry extends CompanyVehicles{
        public CargoLorry(String vehicleNumber, String date, String driverName, String vehicleType) {
            super(vehicleNumber,date,driverName,vehicleType);
        }

        public CargoLorry(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String vehicleParkedSlot) {
            super(vehicleNumber, vehicleType, maximumWeight, numOfPassengers,vehicleParkedSlot);
        }

        public CargoLorry(String date, String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNIC, String vehicleParkedSlot) {
            super(date, vehicleNumber, vehicleType, maximumWeight, numOfPassengers, driverNIC, vehicleParkedSlot);
        }
    }


//    ArrayList For Store Data

    static ArrayList<CompanyVehicles> AllVehicleArrayList = new ArrayList();

    static ArrayList<CompanyVehicles> parkedVehicles = new ArrayList();

    static ArrayList<CompanyVehicles> onShiftVehicles = new ArrayList();

//    Add Vehicle To ArrayList

    static {
        AllVehicleArrayList.add(new Bus("NA-3434", "Bus", 3500, 60, "14"));
        AllVehicleArrayList.add(new Van("KA-4563", "Van", 1000, 7, "01"));
        AllVehicleArrayList.add(new Van("58-3567", "Van", 1500, 4, "02"));
        AllVehicleArrayList.add(new Van("GF-4358", "Van", 800, 4, "03"));
        AllVehicleArrayList.add(new Van("CCB-3568", "Van", 1800, 8, "04"));
        AllVehicleArrayList.add(new Van("LM-6679", "Van", 1500, 4, "12"));
        AllVehicleArrayList.add(new Van("QA-3369", "Van", 1800, 6, "13"));
        AllVehicleArrayList.add(new CargoLorry("KB-3668", "CargoLorry", 2500, 2, "05"));
        AllVehicleArrayList.add(new CargoLorry("JJ-9878", "CargoLorry", 3000, 2, "06"));
        AllVehicleArrayList.add(new CargoLorry("GH-5772", "CargoLorry", 4000, 3, "07"));
        AllVehicleArrayList.add(new CargoLorry("XY-4456", "CargoLorry", 3500, 2, "08"));
        AllVehicleArrayList.add(new CargoLorry("YQ-3536", "CargoLorry", 2000, 2, "09"));
        AllVehicleArrayList.add(new CargoLorry("CBB-3566", "CargoLorry", 2500, 2, "10"));
        AllVehicleArrayList.add(new CargoLorry("QH-3444", "CargoLorry", 5000, 4, "11"));
    }



}
