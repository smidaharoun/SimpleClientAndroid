package smida.haroun.samplemvp.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import smida.haroun.samplemvp.model.Project;
import smida.haroun.samplemvp.model.User;
import smida.haroun.samplemvp.rest.response.BaseResponse;

import static smida.haroun.samplemvp.rest.NetworkConstants.LOGIN;
import static smida.haroun.samplemvp.rest.NetworkConstants.PROJECTS;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public interface RestClient {

    @POST(LOGIN)
    Call<BaseResponse<User>> login(@Query("email") String email, @Query("password") String password);

    @GET(PROJECTS)
    Call<BaseResponse<List<Project>>> getProjects();
}
