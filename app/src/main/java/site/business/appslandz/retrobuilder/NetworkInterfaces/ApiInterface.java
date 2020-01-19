package site.business.appslandz.retrobuilder.NetworkInterfaces;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/users")
    Call<UsersList> getAllUsers();

}
