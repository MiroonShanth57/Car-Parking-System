package Controller;

import Db.Drivers;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class DriverFormController {
    public JFXTextField txtDName;
    public JFXTextField txtAddress;
    public JFXTextField txtDLicense;
    public JFXTextField txtContactNo;
    public JFXTextField txtDNC;

    public void SaveDriverRun(ActionEvent actionEvent) {
        String DName = String.valueOf(txtDName.getText());
        String DContact = String.valueOf(txtContactNo.getText());
        String DAddress = String.valueOf(txtAddress.getText());
        String DLicense = String.valueOf(txtDLicense.getText());
        String DNIC = String.valueOf(txtDNC.getText());


        Drivers.drivers.add(new Drivers(DName,DNIC,DLicense,DAddress,DContact));

        
    }
}
