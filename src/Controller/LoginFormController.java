package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane LoginContext;
    public Label lblError;

    public void BackToHome(ActionEvent actionEvent) {
        Stage stage = (Stage) LoginContext.getScene().getWindow();
        stage.close();
    }

    public void openDashBoard(ActionEvent actionEvent) throws IOException {

        String UserName="Admin";
        String Password="Admin";


        if (txtUserName.getText().equals(UserName) && txtPassword.getText().equals(Password)){
            System.out.println("Done");
            URL resource = getClass().getResource("../View/DashBoardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) LoginContext.getScene().getWindow();
            window.setTitle("Dash Board");
            window.setScene(new Scene(load));
        }else {

            lblError.setText("Wrong username or password");
            txtUserName.setText("");
            txtPassword.setText("");
            System.out.println("Wrong");

        }


    }
}
