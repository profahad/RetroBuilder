package site.business.appslandz.retrobuilder.demo.NetworkInterfaces;


import retrofit2.Call;
import retrofit2.http.GET;
import site.business.appslandz.retrobuilder.demo.Models.UsersList;

public interface ApiInterface {

    @GET("/api/users")
    Call<UsersList> getAllUsers();

}
