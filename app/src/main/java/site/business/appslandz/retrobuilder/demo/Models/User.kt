package site.business.appslandz.retrobuilder.demo.Models

import com.google.gson.annotations.SerializedName

class User(@field:SerializedName("id") var id: Long, @field:SerializedName("first_name") var firstName: String, @field:SerializedName("last_name") var lastName: String, @field:SerializedName("email") var email: String, @field:SerializedName("avatar") var avatar: String) {

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                '}'
    }

}