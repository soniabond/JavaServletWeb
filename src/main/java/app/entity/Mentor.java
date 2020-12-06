package app.entity;

import app.entity.enums.GenderEnum;
import app.entity.enums.KnownAuthority;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
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

    public Mentor(int id, String mail, String city, String placeOfWork, String password, String firstName, String lastName, String phoneNumber, Map<KnownAuthority, UserAuthority> authorities, Set<ProgrammingLangs> programmingLangs, String cooperation, String cooperationPrice) {
        super(id, mail, city, placeOfWork, password, firstName, lastName, phoneNumber, authorities, programmingLangs);
        this.cooperation = cooperation;
        this.cooperationPrice = cooperationPrice;
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
