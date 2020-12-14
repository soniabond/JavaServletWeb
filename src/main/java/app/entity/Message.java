package app.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "messages")
public class Message {

    @EmbeddedId
    private UserMessageId userMessageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userFromId")
    private User userFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userToId")
    private User userTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("langId")
    private ProgrammingLang  programmingLangMessage;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Instant date = Instant.now();

    public Message(){}


    public UserMessageId getUserMessageId() {
        return userMessageId;
    }

    public void setUserMessageId(UserMessageId userMessageId) {
        this.userMessageId = userMessageId;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public ProgrammingLang getProgrammingLangMessage() {
        return programmingLangMessage;
    }

    public void setProgrammingLangMessage(ProgrammingLang programmingLangMessage) {
        this.programmingLangMessage = programmingLangMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return userFrom.equals(message.userFrom) && userTo.equals(message.userTo) && programmingLangMessage.equals(message.programmingLangMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFrom, userTo, programmingLangMessage);
    }
}
