package app.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserMessageId implements Serializable {
    @Column(name = "user_from_id", nullable = false)
    private int userFromId;

    @Column(name = "user_to_id", nullable = false)
    private int userToId;

    @Column(name = "lang_id", nullable = false)
    private int langId;

    public UserMessageId() {
    }

    public UserMessageId(int userFromId, int userToId, int langId) {
        this.userFromId = userFromId;
        this.userToId = userToId;
        this.langId = langId;
    }

    public int getUserToId() {
        return userToId;
    }

    public void setUserToId(int userToId) {
        this.userToId = userToId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMessageId that = (UserMessageId) o;
        return userFromId == that.userFromId && userToId == that.userToId && langId == that.langId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFromId, userToId, langId);
    }

    @Override
    public String toString() {
        return "UserMessageId{" +
                "userFromId=" + userFromId +
                ", userToId=" + userToId +
                ", langId=" + langId +
                '}';
    }
}
