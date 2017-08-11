package smida.haroun.samplemvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smida.haroun.samplemvp.R;
import smida.haroun.samplemvp.adapter.ProjectAdapter;
import smida.haroun.samplemvp.controller.UserController;
import smida.haroun.samplemvp.model.Project;
import smida.haroun.samplemvp.model.User;
import smida.haroun.samplemvp.rest.RestFactory;
import smida.haroun.samplemvp.rest.response.BaseResponse;

public class ProjectListActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        ButterKnife.bind(this);

        loadData();
    }

    private void loadData() {
        showProgressDialog();
        RestFactory.getInstance().getClient().getProjects().enqueue(new Callback<BaseResponse<List<Project>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Project>>> call, Response<BaseResponse<List<Project>>> response) {
                cancelProgressDialog();
                BaseResponse<List<Project>> responseModel = response.body();
                if (responseModel.isStatus()) {
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    ProjectAdapter adapter = new ProjectAdapter(responseModel.getData());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(ProjectListActivity.this, responseModel.getError().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Project>>> call, Throwable t) {
                cancelProgressDialog();
                Toast.makeText(ProjectListActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
