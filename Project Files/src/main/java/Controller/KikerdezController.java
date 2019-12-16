package Controller;

import Controll.Kikerdez.TestPhase;
import Controll.Learning.LearningMethod;
import Controll.fileHandler.JsonReader;
import Controll.fileHandler.ReadFile;
import Modell.User;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class KikerdezController extends TestPhase implements Initializable {

    private Random random = new Random();

    @FXML
    public Button nextButt,quitButt;

    @FXML
    public Text helyes;

    @FXML
    public TextField askedOne,anotherOne;

    public void changeButtonColor() {
        if (nextButt.isHover()) {
            nextButt.setStyle("-fx-background-color: #b9865d");
        } else {
            quitButt.setStyle("-fx-background-color: #b9865d");
        }
    }

    public void changeBackColor() {
        nextButt.setStyle("-fx-background-color: #696969");
        quitButt.setStyle("-fx-background-color: #696969");
    }

    public void quitButtClicked() throws Exception {
        System.exit(0);
    }

    @FXML
    public void checkAnsw() throws IOException {
        checkAnswer(anotherOne.getText(),askedOne.getText(),helyes);

        anotherOne.setDisable(false);
        askedOne.setDisable(false);

        String nextKey =/* (random.nextInt(10) < 8) ? */LearningMethod.fixKeys.get(random.nextInt(10));

        if(random.nextInt(10) < 5){
            anotherOne.setDisable(true);
            anotherOne.setText(nextKey);
            askedOne.setText("");
        }else{
            askedOne.setDisable(true);
            askedOne.setText(LearningMethod.FinalMap.get(nextKey));
            anotherOne.setText("");
        }

        if(TestPhase.learned.size() == 10){
                Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Eredmeny.fxml"));
                Stage eredmenyStage = new Stage();
                eredmenyStage.setTitle("Kezdőképernyő");
                eredmenyStage.setScene(new Scene(parent, 600, 400));
                eredmenyStage.show();
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {



       String starter = LearningMethod.FinalMap.keySet().stream().collect(Collectors.toList()).get(random.nextInt(10));

       anotherOne.setText(starter);
       anotherOne.setDisable(true);

    }



}
