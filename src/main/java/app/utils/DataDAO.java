package app.utils;


import app.bean.SimpleUserInfo;
import app.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DataDAO {

    private static final Map<String, User> mapUsers = new HashMap<String, User>();

    static {
        initUsers();
    }

    private static void initUsers() {


        User emp = new User(1, "trainee1", "123", User.GENDER_MALE,
                SecurityConfig.ROLE_TRAINEE);

        User mng = new User(2, "mentor1", "123", User.GENDER_MALE,
                SecurityConfig.ROLE_MENTOR);

        User emp1 = new User(3, "mentor2", "123", User.GENDER_MALE,
                SecurityConfig.ROLE_MENTOR);


        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
        mapUsers.put(emp1.getUserName(), emp1);
    }

    // Find a User by userName and password.
    public static User findUser(String userName, String password) {
        User u = mapUsers.get(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    // find user public info by username
    public static SimpleUserInfo findSimpleUserInfo(String username){
        SimpleUserInfo userInfo = new SimpleUserInfo();
        User u = mapUsers.get(username);
        if (u == null)
            return null;
        userInfo.setId(u.getId());
        userInfo.setUserName(u.getUserName());
        userInfo.setUserRole(u.getRole());
        return userInfo;
    }

    public static SimpleUserInfo findUserById(long id){

        SimpleUserInfo userInfo = new SimpleUserInfo();
        for(Map.Entry<String, User> mentor: mapUsers.entrySet()) {
            if (mentor.getValue().getId() == id) {
                userInfo.setId(id);
                userInfo.setUserName(mentor.getValue().getUserName());
                return userInfo;
            }
        }

        return null;
    }



    public static List<User> findAllMentors(){
        List<User> userAccounts = new ArrayList<>();
        for(Map.Entry<String, User> mentor: mapUsers.entrySet()){
            if(mentor.getValue().getRole().equals(SecurityConfig.ROLE_MENTOR))
                    userAccounts.add(mentor.getValue());
        }
        return userAccounts;
    }

}
