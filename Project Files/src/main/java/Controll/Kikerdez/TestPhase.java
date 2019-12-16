package Controll.Kikerdez;

import Controller.TanulasController;
import javafx.scene.text.Text;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class TestPhase implements Test {

    private static Map<String,String> allWord = TanulasController.language;

    private static Map<String,Integer> was = new HashMap<>();

    public static  Map<String,String> learned = new HashMap<>();

    /***
     * A válasz helyességét vizsgálja
     * @param key A kulcs értkék a kért válaszból
     * @param value Az érték-része válasz résznek
     * @return Ha helyes a válasz igaz,ha nem,hamis
     */
    private boolean checkCorrect(String key, String value){
        if(allWord.containsKey(key.toLowerCase())){
            return allWord.get(key.toLowerCase()).equals(value.toLowerCase());
        }else{
            return false;
        }

    }

    /***
     * Összefoglalja a válaszkezelő függvényeket
     * @param key A kulcs értkék a kért válaszból
     * @param value Az érték-része válasz résznek
     * @param helyes A helyes választ megjelenítő Text rész ha helytelen a válasz
     */
    public void checkAnswer(String key,String value,Text helyes){
        checkAndAdd(key,value,helyes);
    }

    /***
     * Különgyűjti a már megtanult szavakat.
     * @param key Válasz kulcs
     * @param value Válasz érték
     * @param helyes A helyes választ megjelenítő Text rész ha helytelen a válasz
     */
    private void checkAndAdd(String key,String value,Text helyes){

        if(was.containsKey(key)){

           if(checkCorrect(key,value)) {
               was.put(key, was.get(key) + 1);
               setOnAnsw(key,value,helyes);
           }

            if(was.get(key) == 2)
                learned.put(key,allWord.get(key));

        }else{
            if(checkCorrect(key,value)) {
                was.put(key, 1);
                setOnAnsw(key,value,helyes);
            }
            else {
                was.put(key, 0);
                setOnAnsw(key,value, helyes);
            }
        }

    }

    /***
     * A válasz helyességétől függően állítja a visszajelző szöveget
     * @param key Válasz kulcs
     * @param value Válasz érték
     * @param toSet A helyes választ megjelenítő Text rész ha helytelen a válasz
     */
    private void setOnAnsw(String key,String value, Text toSet){
        if(checkCorrect(key,value)){
            toSet.setText("Helyes válasz");
        }else{
            if(allWord.containsKey(key))
                toSet.setText("Helytelen válasz, helyes válasz: \n" + key + " - " + allWord.get(key));
            else
                toSet.setText("Helytelen válasz, helyes válasz: \n" + allWord.keySet().stream().filter(k -> allWord.get(k).equals(value)).collect(Collectors.toList()).get(0) + " - " + value);
        }
    }

}
