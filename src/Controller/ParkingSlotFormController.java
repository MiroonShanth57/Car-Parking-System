package Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ParkingSlotFormController {
    public Label lblParkingSlot;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox comVehicle;
    public JFXComboBox combDriver;
    public Label lblTypeVehicle;



    {
//        loadDateAndTime();
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
        Date date=new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));


        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void parkingSlotFinderRun(ActionEvent actionEvent) {
    }
}
