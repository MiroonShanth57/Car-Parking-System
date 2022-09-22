package Db;

import java.util.ArrayList;

public class Drivers {
    String Name;
    String NIC;
    String Driving_License_No;
    String Address;
    String Contact;

    public static ArrayList<Drivers> drivers = new ArrayList<>();

    static {
        drivers.add(new Drivers("Sumith Kumara", "7835348345V", "B6474845", "Panadura", "0725637456"));
        drivers.add(new Drivers("Amila Pathirana", "8826253734V", "B3354674", "Galle", "0717573583"));
        drivers.add(new Drivers("Jithmal Perera", "9283289272V", "B3674589", "Horana", "0772452457"));
        drivers.add(new Drivers("Sumith Dissanayaka", "9425245373V", "B8366399", "Kaluthara", "0782686390"));
        drivers.add(new Drivers("Sumanasiri Herath", "8976544373V", "B3537538", "Beruwala", "0772534436"));
        drivers.add(new Drivers("Awantha Fernando", "9173537839V", "B3554789", "Colombo 5", "0714534356"));
        drivers.add(new Drivers("Charith Sudara", "9573536833V", "B6835836", "Baththaramulla", "0771536662"));
        drivers.add(new Drivers("Prashan Dineth", "9362426738V", "B2683536", "Wadduwa", "0715353434"));
        drivers.add(new Drivers("Chethiya Dilan", "9162353436V", "B6836836", "Panadura", "0772436737"));
        drivers.add(new Drivers("Dushantha Perera", "9255556343V", "B3334435", "Matara", "0777245343"));
        drivers.add(new Drivers("Sumith Udayanga", "8735354355V", "B3573783", "Galle", "0703635442"));
        drivers.add(new Drivers("Dinesh Udara", "9026344373V", "B5343783", "Hettimulla", "0713456878"));
        drivers.add(new Drivers("Udana Chathuranga", "9692653338V", "B7888632", "Kottawa", "0772442444"));
        drivers.add(new Drivers("Mohommad Riaz", "9124537733V", "B3638537", "Kaluthara", "0777544222"));
        drivers.add(new Drivers("Sandun Kumara", "9563524267V", "B2263333", "Panadura", "0772325544"));
        drivers.add(new Drivers("Priyanga Perera", "9135343537V", "B3853753", "Matara", "0723344562"));
    }

    public Drivers() {
    }

    public Drivers(String name, String NIC, String driving_License_No, String address, String contact) {
        Name = name;
        this.NIC = NIC;
        Driving_License_No = driving_License_No;
        Address = address;
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDriving_License_No() {
        return Driving_License_No;
    }

    public void setDriving_License_No(String driving_License_No) {
        Driving_License_No = driving_License_No;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return Name ;
    }
}
