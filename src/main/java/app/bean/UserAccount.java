package app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserAccount implements Serializable {
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";

    private String userName;
    private String gender;
    private String password;

    private List<String> roles;

    public UserAccount() {

    }

    public UserAccount(String userName, String password, String gender, String... roles) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;

        this.roles = new ArrayList<String>();
        if (roles != null) {
            for (String r : roles) {
                this.roles.add(r);
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return userName.equals(that.userName) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}