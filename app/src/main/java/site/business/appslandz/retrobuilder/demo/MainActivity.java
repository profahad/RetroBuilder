package site.business.appslandz.retrobuilder.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import site.business.appslandz.retrobuilder.demo.NetworkInterfaces.ApiInterface;
import site.business.appslandz.retrobuilder.demo.Models.UsersList;
import site.business.appslandz.retrobuilder.Interfaces.AuthInitializer;
import site.business.appslandz.retrobuilder.Service.ApiClient;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Call<UsersList> authCall = ApiClient.getInstance(this)
                .setBaseUrl("https://reqres.in")
                .getAuthClient(new AuthInitializer() {
                    @Override
                    public String getBearerToken() {
                        return "Bearer 129318309809843589350938509893540832945";
                    }
                }).create(ApiInterface.class)
                .getAllUsers();

        authCall.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                Timber.i(response.body().toString());
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                call.cancel();
            }
        });

        Call<UsersList> openCall = ApiClient.getInstance(this)
                .setBaseUrl("https://reqres.in")
                .getClient().create(ApiInterface.class)
                .getAllUsers();


        openCall.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                Timber.i(response.body().toString());
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                call.cancel();
            }
        });


    }
}
