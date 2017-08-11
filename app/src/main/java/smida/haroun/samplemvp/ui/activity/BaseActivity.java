package smida.haroun.samplemvp.ui.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import smida.haroun.samplemvp.R;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    public void showProgressDialog() {

        if (progressDialog == null)
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (!BaseActivity.this.isFinishing()) {
                            progressDialog = ProgressDialog.show(BaseActivity.this, "", getString(R.string.loading), true, false);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public void cancelProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (progressDialog != null) {
                        progressDialog.cancel();
                        progressDialog = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
