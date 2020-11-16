package app.entity;

import app.entity.enums.KnownAuthority;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NaturalId
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private KnownAuthority value;

    @ManyToMany(mappedBy = "authorities")
    @SuppressWarnings("FieldMayBeFinal")
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
         UserAuthority that = (UserAuthority) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KnownAuthority getValue() {
        return value;
    }

    public void setValue(KnownAuthority value) {
        this.value = value;
    }

    public Set<User> getUsers() {
        return users;
    }

}
