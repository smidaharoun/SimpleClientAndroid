package smida.haroun.samplemvp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import smida.haroun.samplemvp.model.User;
import smida.haroun.samplemvp.utility.SPManager;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class UserController {

    private static final String KEY_USER = "user";

    public static void setCurrentUser(User user) {
        Gson gson = new GsonBuilder().create();
        SPManager.putString(KEY_USER, gson.toJson(user));
    }

    public static User getCurrentUser() {
        if (SPManager.getString(KEY_USER) != null) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(SPManager.getString(KEY_USER) , User.class);
        }

        return null;
    }

}
