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

    @Column(name = "self_description")
    private String description;

    @Column(name = "cooperation_conditions")
        private String cooperation;

    @Column(name = "cooperation_price")
    private String cooperationPrice;

    public Mentor(){}

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UserLanguage> langs = new HashSet<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserLanguage> getLangs() {
        return langs;
    }

    public void setLangs(Set<UserLanguage> langs) {
        this.langs = langs;
    }

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
