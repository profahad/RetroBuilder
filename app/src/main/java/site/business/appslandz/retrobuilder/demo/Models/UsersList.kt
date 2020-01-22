package site.business.appslandz.retrobuilder.demo.Models

import com.google.gson.annotations.SerializedName

class UsersList(@field:SerializedName("data") var userList: List<User>? = null) {

    override fun toString(): String {
        return "UsersList{" +
                "userList=" + userList +
                '}'
    }

}