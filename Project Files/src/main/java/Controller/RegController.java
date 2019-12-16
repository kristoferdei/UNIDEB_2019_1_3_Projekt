package Controller;

import Controll.Bejelentkezes.LoginPhase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegController extends LoginPhase {


    Stage regStage;
    public Button okButt;

    @FXML
    public TextField uname;

    @FXML
    public PasswordField passwd;

    public void handleChangeButtonClicked() throws Exception{

        if(validatePassword(passwd.getText(),uname.getText(),UdvozloController.users)) {
            UdvozloController.popBox("Sikeres regisztráció","Siker");

            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Udvozlo.fxml"));
            regStage = new Stage();
            regStage.setTitle("Kezdőképernyő");
            regStage.setScene(new Scene(parent, 600, 400));
            regStage.show();
        }else
            UdvozloController.popBox("Ooops...valami hiba történt","Hiba");
    }

    public void changeButtonColor() {
        if (okButt.isHover()) {
            okButt.setStyle("-fx-background-color: #b9865d");
        }
    }

    public void changeBackColor() {
        okButt.setStyle("-fx-background-color: #696969");
    }

}
