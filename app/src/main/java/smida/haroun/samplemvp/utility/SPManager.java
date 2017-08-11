package smida.haroun.samplemvp.utility;

/**
 * Copyright (c) 2017, Haroun Smida
 * Created on 07/01/17.
 * tunisiezipcode
 */

import android.content.Context;
import android.content.SharedPreferences;

public class SPManager {


    private static SharedPreferences sp;

    public static void initialize(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("app", Context.MODE_PRIVATE);
        }
    }


    public static boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public static int getInt(String key) {
        return sp.getInt(key, -1);
    }

    public static String getString(String key) {
        return sp.getString(key, null);
    }

    public static void putString(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public static void putInt(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public static void putBoolean(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

}
