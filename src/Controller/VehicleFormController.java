package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class VehicleFormController {
    public JFXTextField txtVNumber;
    public JFXComboBox cmbVType;
    public JFXTextField txtNoOfPassengers;
    public JFXTextField txtVMaWei;
    public JFXTextField txtSlot;

    public void initialize(){
        cmbVType.setItems(FXCollections.observableArrayList("Bus","Van", "CargoLorry"));
    }

    public void SaveVehicle(ActionEvent actionEvent) {
        if (String.valueOf(cmbVType.getValue()).equals("Van")) {

            CompanyVehicles.AllVehicleArrayList.add(new CompanyVehicles.Van(txtVNumber.getText(), String.valueOf(cmbVType.getValue()), Integer.valueOf(txtVMaWei.getText()), Integer.valueOf(txtNoOfPassengers.getText()), txtSlot.getText()));
            System.out.println("van Done");
        } else if (String.valueOf(cmbVType.getValue()).equals("CargoLorry")){
            CompanyVehicles.AllVehicleArrayList.add(new CompanyVehicles.Van(txtVNumber.getText(), String.valueOf(cmbVType.getValue()), Integer.valueOf(txtVMaWei.getText()), Integer.valueOf(txtNoOfPassengers.getText()), txtSlot.getText()));
            System.out.println("Lorry Done");

        }else if(String.valueOf(cmbVType.getValue()).equals("Bus")){

            CompanyVehicles.AllVehicleArrayList.add(new CompanyVehicles.Van(txtVNumber.getText(), String.valueOf(cmbVType.getValue()), Integer.valueOf(txtVMaWei.getText()), Integer.valueOf(txtNoOfPassengers.getText()), txtSlot.getText()));
            System.out.println("Bus Done");

        }

    }
}
