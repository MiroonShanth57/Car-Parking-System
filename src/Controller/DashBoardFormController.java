package Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {
    public TableColumn colVNumber;
    public TableColumn colVType;
    public TableColumn colPSlot;
    public TableColumn colPTime;
    public TableColumn colVNumberT2;
    public TableColumn colVTypeT2;
    public TableColumn colDNameT2;
    public TableColumn colLTimeT2;
    public AnchorPane DashBoardContext;
    public TableView tblDelivery;
    public TableView tblParking;


    public void initialize() {
        loadTableToForm();
    }

    public void OpenDriverForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/DriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Driver Form");
        stage.show();
        stage.setResizable(false);

    }

    public void openVehicleForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/VehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Vehicle Form");
        stage.show();
        stage.setResizable(false);

    }

    public void BackToHomePage(ActionEvent actionEvent) {
        Stage stage = (Stage) DashBoardContext.getScene().getWindow();
        stage.close();
    }

    public void loadTableToForm() {

//        Load details to the tables

            tblParking.setItems(FXCollections.observableArrayList(CompanyVehicles.parkedVehicles));
            colVNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
            colVType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
            colPSlot.setCellValueFactory(new PropertyValueFactory("vehicleParkedSlot"));
            colPTime.setCellValueFactory(new PropertyValueFactory("date"));



            tblDelivery.setItems(FXCollections.observableArrayList(CompanyVehicles.onShiftVehicles));
            colVNumberT2.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
            colVTypeT2.setCellValueFactory(new PropertyValueFactory("vehicleType"));
            colDNameT2.setCellValueFactory(new PropertyValueFactory("driverName"));
            colLTimeT2.setCellValueFactory(new PropertyValueFactory("date"));

    }
}
