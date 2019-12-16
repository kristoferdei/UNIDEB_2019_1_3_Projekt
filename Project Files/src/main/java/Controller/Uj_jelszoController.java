package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Uj_jelszoController {

    Stage newPassStage;
    public Button changeButt, okButt;

    public void handleChangeButtonClicked() throws Exception{

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Udvozlo.fxml"));
        newPassStage = new Stage();
        newPassStage.setTitle("Kezdőképernyő");
        newPassStage.setScene(new Scene(parent, 600, 400));
        newPassStage.show();

    }

    public void changeButtonColor() {
        if (changeButt.isHover()) {
            changeButt.setStyle("-fx-background-color: #b9865d");
        }else {
            okButt.setStyle("-fx-background-color: #b9865d");
        }

    }

    public void changeBackColor() {
            changeButt.setStyle("-fx-background-color: #696969");
            okButt.setStyle("-fx-background-color: #696969");

    }

}
