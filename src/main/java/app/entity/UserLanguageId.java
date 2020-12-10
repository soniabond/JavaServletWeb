package app.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserLanguageId implements Serializable {

        @Column(name = "user_id")
        private int userId;

        @Column(name = "lang_id")
        private int langId;

    public UserLanguageId(int userId, int langId) {
        this.userId = userId;
        this.langId = langId;
    }

    public UserLanguageId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLanguageId that = (UserLanguageId) o;
        return userId == that.userId && langId == that.langId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, langId);
    }

    @Override
    public String toString() {
        return "UserLanguageId{" +
                "userId=" + userId +
                ", langId=" + langId +
                '}';
    }
}
