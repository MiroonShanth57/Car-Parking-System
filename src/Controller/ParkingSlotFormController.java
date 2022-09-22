package Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import java.util.Date;

public class ParkingSlotFormController {
    public Label lblParkingSlot;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox comVehicle;
    public JFXComboBox combDriver;
    public Label lblTypeVehicle;


    public void initialize() {
        loadDateAndTime();
    }


    public void ParkVehicleRun(ActionEvent actionEvent) {
    }

    public void OnDiliveryShiftRun(ActionEvent actionEvent) {
    }

    public void OpenManagementDash(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../View/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("DashBoard");
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

    public void parkingSlotFinderRun(ActionEvent actionEvent) {
    }
}
