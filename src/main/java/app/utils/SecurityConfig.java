package app.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

    public static final String ROLE_TRAINEE = "TRAINEE";
    public static final String ROLE_MENTOR = "MENTOR";

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {


        List<String> urlPatternsMentor = new ArrayList<>();

        urlPatternsMentor.add("/myInfo");

        mapConfig.put(ROLE_MENTOR, urlPatternsMentor);


        List<String> urlPatternsTrainee = new ArrayList<>();

        urlPatternsMentor.add("/myInfo");

        mapConfig.put(ROLE_TRAINEE, urlPatternsMentor);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}
