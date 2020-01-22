package site.business.appslandz.retrobuilder.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.business.appslandz.retrobuilder.Interfaces.AuthInitializer
import site.business.appslandz.retrobuilder.Service.ApiClient
import site.business.appslandz.retrobuilder.Service.ApiResponse
import site.business.appslandz.retrobuilder.demo.Models.User
import site.business.appslandz.retrobuilder.demo.Models.UsersList
import site.business.appslandz.retrobuilder.demo.NetworkInterfaces.ApiInterface
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ApiClient.getInstance(this)
                .setBaseUrl("https://reqres.in")

        val authCall = ApiClient.getInstance(this)
                .getAuthClient(object : AuthInitializer {
                    override val bearerToken: String
                        get() = "Bearer 129318309809843589350938509893540832945"
                }).create(ApiInterface::class.java).getUsers()
        authCall.enqueue(object : Callback<ApiResponse<List<User>>> {
            override fun onFailure(call: Call<ApiResponse<List<User>>>, t: Throwable) {
                call.cancel()
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ApiResponse<List<User>>>, response: Response<ApiResponse<List<User>>>) {
                Timber.d(response.body()?.data.toString())
            }

        })
    }
}