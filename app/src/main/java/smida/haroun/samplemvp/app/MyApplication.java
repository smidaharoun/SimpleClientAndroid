package smida.haroun.samplemvp.app;

import android.app.Application;

import smida.haroun.samplemvp.utility.SPManager;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeManagers();
    }

    private void initializeManagers() {
        SPManager.initialize(this);
    }
}
