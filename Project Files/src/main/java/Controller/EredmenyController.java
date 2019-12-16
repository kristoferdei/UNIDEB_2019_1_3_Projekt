package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.text.Style;

public class EredmenyController {

    public Button backButt;
    Stage eredmenyStage;

    public void handleBackButtonClicked() throws Exception{

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Udvozlo.fxml"));
        eredmenyStage = new Stage();
        eredmenyStage.setTitle("Kezdőképernyő");
        eredmenyStage.setScene(new Scene(parent, 600, 400));
        eredmenyStage.show();
    }

    public void changeButtonColor(){
        backButt.setStyle("-fx-background-color: #b9865d");
    }

    public void changeBackColor(){
        backButt.setStyle("-fx-background-color: #696969");
    }

}
