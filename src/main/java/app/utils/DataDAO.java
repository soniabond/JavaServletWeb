package app.utils;


import app.bean.UserAccount;

import java.util.HashMap;
import java.util.Map;



public class DataDAO {

    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

    static {
        initUsers();
    }

    private static void initUsers() {

        // This user has a role as EMPLOYEE.
        UserAccount emp = new UserAccount("trainee1", "123", UserAccount.GENDER_MALE, //
                SecurityConfig.ROLE_MENTOR);

        // This user has 2 roles EMPLOYEE and MANAGER.
        UserAccount mng = new UserAccount("mentor1", "123", UserAccount.GENDER_MALE, //
                SecurityConfig.ROLE_MENTOR, SecurityConfig.ROLE_TRAINEE);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
    }

    // Find a User by userName and password.
    public static UserAccount findUser(String userName, String password) {
        UserAccount u = mapUsers.get(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

}
