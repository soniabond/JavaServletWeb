package app.bean;

import java.io.Serializable;
import java.util.Objects;

public class SimpleUserInfo implements Serializable {
    long id;
    String userName;
    String userRole;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUserInfo that = (SimpleUserInfo) o;
        return userName.equals(that.userName) &&
                userRole.equals(that.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userRole);
    }

    @Override
    public String toString() {
        return "SimpleUserInfo{" +
                "userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

}
