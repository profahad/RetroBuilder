package site.business.appslandz.retrobuilder.Service

import com.google.gson.annotations.SerializedName


class ApiResponse<T> {
    @SerializedName("status")
    var status: Boolean? = null
    @SerializedName("message")
    var message: String? = null
    @SerializedName("data")
    var data: T? = null

    override fun toString(): String {
        return "ApiResponse(status=$status, message=$message, data=$data)"
    }


}