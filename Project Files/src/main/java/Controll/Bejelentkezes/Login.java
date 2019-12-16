package Controll.Bejelentkezes;

import Modell.User;

import java.util.Map;

public interface Login {

    boolean validatePassword(String passwd,String uname,Map<String, User> users);

    String hasher(String passwd);

    String deCoder(String passwd);
}
