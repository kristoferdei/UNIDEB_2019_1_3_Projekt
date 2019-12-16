package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class NyelvvController {

    Stage learnStage;
    public Button quitButt;

    public void handleFlagImageClicked() throws Exception{
        Parent learn = FXMLLoader.load(getClass().getResource("/fxml/Tanulas.fxml"));
        learnStage = new Stage();
        learnStage.setTitle("Nyelvválasztás");
        learnStage.setScene(new Scene(learn, 600, 400));
        learnStage.show();
    }

    public void changeButtonColor(){
        quitButt.setStyle("-fx-background-color: #b9865d");
    }

    public void changeBackColor() {
        quitButt.setStyle("-fx-background-color: #696969");
    }

    public void quitButtClicked() throws Exception {
        System.exit(0);
    }

}
