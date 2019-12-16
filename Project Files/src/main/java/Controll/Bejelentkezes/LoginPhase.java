package Controll.Bejelentkezes;

import Controll.fileHandler.JsonWriter;
import Modell.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginPhase implements Login {

    private String hash1 = "npnpnipibnvajoofa";
    private String hash2 = "phuboanovnipkanvp";

    private JsonWriter jsonWriter = new JsonWriter("/Assets/users.json");

    /***
     *Ellenőrzi, megfelel-e a megadott kritériumoknak a felhasználó jelszava
     * @param passwd A felhasználó által használni kívánt jelszó
     * @param uname A felhasználó által használni kívánt felhasználónév
     * @param users A már beregisztrált felhasználók listája
     * @return igaz,ha még nem foglalt a felhasználónév, a jelszó hossza 16 alatt van és csak a-tól z-ig kics vagy nagy betűket tartalmaz,illetve számokat
     */
    @Override
    public boolean validatePassword(String passwd,String uname,Map<String,User> users) {
        if(passwd.matches("[0-9A-Za-z]*") && !users.containsValue(users.get(hasher(passwd))) && passwd.length() <= 16){
            User newUser = new User(uname,"0000",new HashMap<String,String>());
            users.put(hasher(passwd),newUser);
            jsonWriter.writeToJson(users);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Kódolja a felhasználó jelszavát és hozzáfűz 2 hash-t
     * @param passwd A felhasználó jelszava
     * @return a hashelt és kódolt jelszó
     */
    @Override
    public String hasher(String passwd) {
        return hash1 +  caesarCoder(passwd) + hash2;
    }

    /***
     * Caesar kódolót használva kódolja a jelszót
     * @param passwd A felhasználó jelszava
     * @return a Caesar kódolt jelszó
     */
    private StringBuffer caesarCoder(String passwd) {
    	int s = 5;
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<passwd.length(); i++) 
        { 
            if (Character.isUpperCase(passwd.charAt(i))) 
            { 
                char ch = (char)(((int)passwd.charAt(i) + 
                                  s - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)passwd.charAt(i) + 
                                  s - 97) % 26 + 97); 
                result.append(ch); 
            } 
        } 
        return result;
    }

    @Override
    public String deCoder(String passwd) {
        return null;
    }
}
