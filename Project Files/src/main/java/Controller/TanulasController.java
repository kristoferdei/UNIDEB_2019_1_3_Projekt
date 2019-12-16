package Controller;

import Controll.Languages.English;
import Controll.Learning.LearningMethod;
import Controll.fileHandler.JsonReader;
import Controll.fileHandler.ReadFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TanulasController extends LearningMethod implements Initializable {

        public static Map<String,String> language = new HashMap<String,String>();

        private Type token = new TypeToken<Map<String, String>>(){}.getType();

        private ReadFile jsonReader = new JsonReader("/Assets/english.json",token);

        private int counter;

        Stage testStage;

        @FXML
        public Button prevButt,testButt,nextButt,quitButt;

        @FXML
        public Text key,value;

    public void handleTestButtonClicked() throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Kikerdez.fxml"));
        testStage = new Stage();
        testStage.setTitle("Tanulás");
        testStage.setScene(new Scene(parent, 600, 400));
        testStage.show();
    }

    public void changeButtonColor(){
        if (prevButt.isHover()){
            prevButt.setStyle("-fx-background-color: #b9865d");
        }else if (testButt.isHover()){
            testButt.setStyle("-fx-background-color: #b9865d");
        }else if (nextButt.isHover()) {
            nextButt.setStyle("-fx-background-color: #b9865d");
        }else{
            quitButt.setStyle("-fx-background-color: #b9865d");
        }
    }

    public void changeBackColor(){
        prevButt.setStyle("-fx-background-color: #696969");
        testButt.setStyle("-fx-background-color: #696969");
        nextButt.setStyle("-fx-background-color: #696969");
        quitButt.setStyle("-fx-background-color: #696969");
    }

    public void quitButtClicked() throws Exception {
        System.exit(0);
    }

    @FXML
    public void prevWord(){
        if(counter > 0) {
            setPreWord(key.getText(),key,value);
            counter -= 1;
            nextButt.setDisable(false);
        }else if(counter == 0)
            prevButt.setDisable(true);
    }

    @FXML
    public void nextWord(){
        if(counter < fixKeys.size()-1) {
            setNextWord(key.getText(),key,value);
            counter += 1;
            prevButt.setDisable(false);
        }else if(counter == fixKeys.size()-1) {
            nextButt.setDisable(true);
            testButt.setDisable(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        language = jsonReader.readFromJson(language);

        if(language == null){
            ObjectMapper object = new ObjectMapper();
            try {
                language = object.readValue(English.getEnglishWords(),Map.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        get10Random(language);

        key.setText(fixKeys.get(0));
        value.setText(FinalMap.get(fixKeys.get(0)));

        prevButt.setDisable(true);
        testButt.setDisable(true);
        counter=0;


    }

}

