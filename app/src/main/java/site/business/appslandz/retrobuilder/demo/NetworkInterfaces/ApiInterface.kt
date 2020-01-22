package site.business.appslandz.retrobuilder.demo.NetworkInterfaces

import retrofit2.Call
import retrofit2.http.GET
import site.business.appslandz.retrobuilder.Service.ApiResponse
import site.business.appslandz.retrobuilder.demo.Models.User
import site.business.appslandz.retrobuilder.demo.Models.UsersList

interface ApiInterface {
    @GET("/api/users")
    fun getUsers() : Call<ApiResponse<List<User>>>
}