package app.entity;

import app.entity.enums.KnownAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "mentors")
@DiscriminatorValue("MENT")
@SuppressWarnings("FieldMayBeFinal")
public class Mentor extends User {
    @Column(name = "cooperation_conditions")
        private String cooperation;

    @Column(name = "cooperation_price")
    private String cooperationPrice;

    public Mentor(){}

    public Mentor(int id, String mail, String city, String placeOfWork, String password, String firstName, String lastName, String phoneNumber, Map<KnownAuthority, UserAuthority> authorities, String cooperation, String cooperationPrice, Set<UserLanguage> posts) {
        super(id, mail, city, placeOfWork, password, firstName, lastName, phoneNumber, authorities);
        this.cooperation = cooperation;
        this.cooperationPrice = cooperationPrice;
        this.langs = posts;
    }

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UserLanguage> langs = new HashSet<>();



    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public String getCooperationPrice() {
        return cooperationPrice;
    }

    public void setCooperationPrice(String cooperationPrice) {
        this.cooperationPrice = cooperationPrice;
    }

    @Override
    public String toString() {
        return super.toString() +
                "cooperation='" + cooperation + '\'' +
                ", cooperationPrice='" + cooperationPrice + '\'' +
                '}';
    }
}
