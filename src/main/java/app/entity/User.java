package app.entity;

import app.entity.enums.KnownAuthority;
import app.entity.enums.GenderEnum;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
public abstract class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String mail;

    public User(int id, String mail, String password,
                String firstName, String lastName, String phoneNumber,
                Map<KnownAuthority, UserAuthority> authorities,
                Set<ProgrammingLangs> programmingLangs) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
        this.programmingLangs = programmingLangs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "first_name")
    private String firstName;


    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;



    public Set<ProgrammingLangs> getProgrammingLangs() {
        return programmingLangs;
    }

    public void setProgrammingLangs(Set<ProgrammingLangs> programmingLangs) {
        this.programmingLangs = programmingLangs;
    }



    @ManyToMany
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKey(name = "value")
    private Map<KnownAuthority, UserAuthority> authorities = new EnumMap<>(KnownAuthority.class);

    @ManyToMany
    @JoinTable(name = "user_languages",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id")
    )
    private Set<ProgrammingLangs> programmingLangs = new HashSet<>();

    public User(){}

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Map<KnownAuthority, UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Map<KnownAuthority, UserAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                mail.equals(user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", programmingLangs=" + programmingLangs +
                ", authorities=" + authorities +
                '}';
    }
}