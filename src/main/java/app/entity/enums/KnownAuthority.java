package app.entity.enums;

public enum KnownAuthority {
    ROLE_MENTOR,
    ROLE_TRAINEE;

    public String getAuthority() {
        return name();
    }

}
