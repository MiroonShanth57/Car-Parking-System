package Controller;

import Db.Drivers;
import Db.ParkingSlot;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.text.SimpleDateFormat;

import java.util.Collections;
import java.util.Date;

public class ParkingSlotFormController {
    public Label lblParkingSlot;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox comVehicle;
    public JFXComboBox combDriver;
    public Label lblTypeVehicle;
    public JFXButton btnVehiclePark;
    public JFXButton btnDeliveryShift;


    public void initialize() {
        loadDateAndTime();

        combDriver.setItems(FXCollections.observableArrayList(Drivers.drivers));

        ObservableList<CompanyVehicles> companyVehicles = FXCollections.observableArrayList(CompanyVehicles.AllVehicleArrayList);
        comVehicle.setItems(companyVehicles);
    }


    public void ParkVehicleRun(ActionEvent actionEvent) {


        CompanyVehicles check = (CompanyVehicles) comVehicle.getValue();
        btnVehiclePark.setDisable(false);

//Get parking date And Time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();

        System.out.println(formatter.format(date));


        if (lblTypeVehicle.getText().equals("Van")) {
            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();

//            Add Date To parkedVehicles ArrayList
            CompanyVehicles.parkedVehicles.add(new CompanyVehicles.Van(formatter.format(date),vehicle.getVehicleNumber(),vehicle.getVehicleType(),vehicle.getMaximumWeight(),vehicle.getNumOfPassengers(),vehicle.getDriverNIC(),lblParkingSlot.getText()));

            ParkingSlot.vanParking.remove(Integer.valueOf(lblParkingSlot.getText()));

            for (int i = 0; i < CompanyVehicles.onShiftVehicles.size(); i++) {
                CompanyVehicles tempCompanyVehicles = CompanyVehicles.onShiftVehicles.get(i);
                if (vehicle.getVehicleNumber().equals(tempCompanyVehicles.getVehicleNumber())) {
                    CompanyVehicles.onShiftVehicles.remove(CompanyVehicles.onShiftVehicles.get(i));
                }
            }
            System.out.println(vehicle.getVehicleNumber());

        } else if (lblTypeVehicle.getText().equals("CargoLorry")) {

            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();

            CompanyVehicles.parkedVehicles.add(new CompanyVehicles.CargoLorry(formatter.format(date),vehicle.getVehicleNumber(),vehicle.getVehicleType(),vehicle.getMaximumWeight(),vehicle.getNumOfPassengers(),vehicle.getDriverNIC(),lblParkingSlot.getText()));

            ParkingSlot.cargoLorryParking.remove(Integer.valueOf(lblParkingSlot.getText()));

            for (int i = 0; i < CompanyVehicles.onShiftVehicles.size(); i++) {

                CompanyVehicles tempCompanyVehicles = CompanyVehicles.onShiftVehicles.get(i);

                if (vehicle.getVehicleNumber().equals(tempCompanyVehicles.getVehicleNumber())) {

                    CompanyVehicles.onShiftVehicles.remove(CompanyVehicles.onShiftVehicles.get(i));
                }
            }
            //System.out.println(vehicle.vehicleNUmber);
        } else {

            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();

            CompanyVehicles.parkedVehicles.add(new CompanyVehicles.Bus(formatter.format(date),vehicle.getVehicleNumber(),vehicle.getVehicleType(),vehicle.getMaximumWeight(),vehicle.getNumOfPassengers(),vehicle.getDriverNIC(),lblParkingSlot.getText()));

            for (int i = 0; i < CompanyVehicles.onShiftVehicles.size(); i++) {

                CompanyVehicles tempCompanyVehicles = CompanyVehicles.onShiftVehicles.get(i);

                if (vehicle.getVehicleNumber().equals(tempCompanyVehicles.getVehicleNumber())) {

                    CompanyVehicles.onShiftVehicles.remove(CompanyVehicles.onShiftVehicles.get(i));

                }
            }
        }

        for (int i = 0; i < CompanyVehicles.parkedVehicles.size(); i++) {

            CompanyVehicles vehicle = CompanyVehicles.parkedVehicles.get(i);

            if (check.getVehicleNumber().equals(vehicle.getVehicleNumber())) {

                btnVehiclePark.setDisable(true);
            }
        }

        CompanyVehicles check0 = (CompanyVehicles) comVehicle.getValue();

        for (int i = 0; i < CompanyVehicles.parkedVehicles.size(); i++) {

            CompanyVehicles vehicle = CompanyVehicles.parkedVehicles.get(i);

            if (check0.getVehicleNumber().equals(vehicle.getVehicleNumber()) /*&& selectDriver.getValue() != null*/) {

                btnDeliveryShift.setDisable(false);
            }
        }

    }

    public void OnDiliveryShiftRun(ActionEvent actionEvent) {


//        Get Shift Out Date And Time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();


        if (lblTypeVehicle.getText().equals("Van")) {
            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();
            Drivers driver = (Drivers) combDriver.getValue();
            CompanyVehicles.onShiftVehicles.add(new CompanyVehicles.Van(vehicle.getVehicleNumber(),formatter.format(date),driver.getName(),vehicle.getVehicleType()));

            for (int i = 0; i < CompanyVehicles.parkedVehicles.size(); i++) {

                CompanyVehicles tempVehicle = CompanyVehicles.parkedVehicles.get(i);

                if (vehicle.getVehicleNumber().equals(tempVehicle.getVehicleNumber())) {
                    CompanyVehicles.parkedVehicles.remove(CompanyVehicles.parkedVehicles.get(i));
                    ParkingSlot.vanParking.add(Integer.valueOf(tempVehicle.getVehicleParkedSlot()));
                    Collections.sort(ParkingSlot.vanParking);
                }

            }

        } else if (lblTypeVehicle.getText().equals("CargoLorry")) {

            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();

            Drivers driver = (Drivers) combDriver.getValue();

            CompanyVehicles.onShiftVehicles.add(new CompanyVehicles.CargoLorry(vehicle.getVehicleNumber(),formatter.format(date),driver.getName(),vehicle.getVehicleType()));

            for (int i = 0; i < CompanyVehicles.parkedVehicles.size(); i++) {

                CompanyVehicles tempVehicle = CompanyVehicles.parkedVehicles.get(i);

                if (vehicle.getVehicleNumber().equals(tempVehicle.getVehicleNumber())) {

                    CompanyVehicles.parkedVehicles.remove(CompanyVehicles.parkedVehicles.get(i));

                    ParkingSlot.cargoLorryParking.add(Integer.valueOf(tempVehicle.getVehicleParkedSlot()));

                    Collections.sort(ParkingSlot.cargoLorryParking);
                }
            }

        } else {

            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();

            Drivers driver = (Drivers) combDriver.getValue();

            CompanyVehicles.onShiftVehicles.add(new CompanyVehicles.Bus(vehicle.getVehicleNumber(),formatter.format(date),driver.getName(),vehicle.getVehicleType()));

            for (int i = 0; i < CompanyVehicles.parkedVehicles.size(); i++) {

                CompanyVehicles tempVehicle = CompanyVehicles.parkedVehicles.get(i);

                if (vehicle.getVehicleNumber().equals(tempVehicle.getVehicleNumber())) {

                    CompanyVehicles.parkedVehicles.remove(CompanyVehicles.parkedVehicles.get(i));
                }
            }
        }

        CompanyVehicles checkVehicle = (CompanyVehicles) comVehicle.getValue();

        for (int i = 0; i < CompanyVehicles.onShiftVehicles.size(); i++) {

            CompanyVehicles vehicle = CompanyVehicles.onShiftVehicles.get(i);

            if (checkVehicle.getVehicleNumber().equals(vehicle.getVehicleNumber())) {

                CompanyVehicles.parkedVehicles.remove(CompanyVehicles.onShiftVehicles.get(i));

                btnVehiclePark.setDisable(false);
                btnDeliveryShift.setDisable(true);
            }
        }


    }

    public void OpenManagementDash(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../View/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Log In Page");
        stage.show();

    }

    public void loadDateAndTime(){
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dateShow = new Date();

        lblDate.setText(formatter1.format(dateShow));
        Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(time);
                });
            }
        });
        timerThread.start();
    }


    int selectedVan = 0;
    int selectedLorry = 0;

    public void parkingSlotFinderRun(ActionEvent actionEvent) {
        btnDeliveryShift.setDisable(true);

        if (comVehicle.getValue() != null) {

            CompanyVehicles check = (CompanyVehicles) comVehicle.getValue();

            for (int i = 0; i < CompanyVehicles.parkedVehicles.size(); i++) {

                CompanyVehicles vehicle = CompanyVehicles.parkedVehicles.get(i);

                if (check.getVehicleNumber().equals(vehicle.getVehicleNumber())) {

                    btnVehiclePark.setDisable(true);
                    btnDeliveryShift.setDisable(false);
                    break;

                } else btnVehiclePark.setDisable(false);

            }



            CompanyVehicles vehicle = (CompanyVehicles) comVehicle.getValue();

            lblTypeVehicle.setText(vehicle.getVehicleType());

            if (vehicle.getVehicleType().equals("Van")) {

                lblParkingSlot.setText(String.valueOf(ParkingSlot.vanParking.get(selectedVan)));
                //j++;
            } else if (vehicle.getVehicleType().equals("Bus")) {

                lblParkingSlot.setText("14");
            } else if (vehicle.getVehicleType().equals("CargoLorry")) {

                lblParkingSlot.setText(String.valueOf(ParkingSlot.cargoLorryParking.get(selectedLorry)));

                //i++;
            }
        }
    }
}
