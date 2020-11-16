package app.entity.enums;

public enum KnownAuthority {
    ROLE_MENTOR,
    ROLE_TRAINEE,
    ROLE_ADMIN;

    public String getAuthority() {
        return name();
    }

}
