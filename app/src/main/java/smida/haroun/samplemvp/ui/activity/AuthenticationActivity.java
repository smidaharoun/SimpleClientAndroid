package smida.haroun.samplemvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smida.haroun.samplemvp.R;
import smida.haroun.samplemvp.controller.UserController;
import smida.haroun.samplemvp.model.User;
import smida.haroun.samplemvp.rest.RestFactory;
import smida.haroun.samplemvp.rest.response.BaseResponse;

public class AuthenticationActivity extends BaseActivity {

    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.authenticateButton)
    public void onAuthenticateClicked() {
        showProgressDialog();
        RestFactory.getInstance().getClient().login(emailEditText.getText().toString(), passwordEditText.getText().toString()).enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(Call<BaseResponse<User>> call, Response<BaseResponse<User>> response) {
                cancelProgressDialog();
                BaseResponse<User> responseModel = response.body();
                if (responseModel.isStatus()) {
                    UserController.setCurrentUser(responseModel.getData());
                    startActivity(new Intent(AuthenticationActivity.this, ProjectListActivity.class));
                } else {
                    Toast.makeText(AuthenticationActivity.this, responseModel.getError().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<User>> call, Throwable t) {
                cancelProgressDialog();
                Toast.makeText(AuthenticationActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
