package smida.haroun.samplemvp.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class RestFactory {

    private static RestFactory instance;

    private RestFactory() {
    }

    public synchronized static RestFactory getInstance() {
        if (instance == null) instance = new RestFactory();
        return instance;
    }

    public RestClient getClient() {
        OkHttpClient client = getOkHttpClientDefault();
        Retrofit retrofit = getRetrofit(client);
        return retrofit.create(RestClient.class);
    }


    private OkHttpClient getOkHttpClientDefault() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        return clientBuilder.build();
    }

    private Retrofit getRetrofit(OkHttpClient client) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        return new Retrofit.Builder()
                .baseUrl(NetworkConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
