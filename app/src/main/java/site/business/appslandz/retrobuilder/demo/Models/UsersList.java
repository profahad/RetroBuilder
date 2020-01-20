package site.business.appslandz.retrobuilder.demo.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersList {

    @SerializedName("data")
    public List<User> userList;

    public UsersList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "userList=" + userList +
                '}';
    }
}
