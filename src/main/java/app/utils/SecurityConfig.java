package app.utils;

import app.entity.enums.KnownAuthority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {


        List<String> urlPatternsMentor = new ArrayList<>();

        urlPatternsMentor.add("/myInfo");

        mapConfig.put(KnownAuthority.ROLE_MENTOR.getAuthority(), urlPatternsMentor);


        List<String> urlPatternsTrainee = new ArrayList<>();

        urlPatternsMentor.add("/myInfo");

        mapConfig.put(KnownAuthority.ROLE_TRAINEE.getAuthority(), urlPatternsTrainee);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}
