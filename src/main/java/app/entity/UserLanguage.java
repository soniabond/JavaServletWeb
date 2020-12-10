package app.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_language")
public class UserLanguage {

    @EmbeddedId
    private UserLanguageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private Mentor user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("langId")
    private ProgrammingLang lang;

    @Column(name = "descripiton")
    private String description;

    public UserLanguage(UserLanguageId id, Mentor user, ProgrammingLang lang, String description) {
        this.id = id;
        this.user = user;
        this.lang = lang;
        this.description = description;
    }

    public UserLanguage(){}

    public UserLanguageId getId() {
        return id;
    }

    public void setId(UserLanguageId id) {
        this.id = id;
    }

    public Mentor getUser() {
        return user;
    }

    public void setUser(Mentor user) {
        this.user = user;
    }

    public ProgrammingLang getLang() {
        return lang;
    }

    public void setLang(ProgrammingLang lang) {
        this.lang = lang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLanguage that = (UserLanguage) o;
        return user.equals(that.user) && lang.equals(that.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, lang);
    }
}