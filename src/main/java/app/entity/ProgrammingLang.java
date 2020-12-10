package app.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "programming_langs")
public class ProgrammingLang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    @Column(nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "lang",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UserLanguage> users = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserLanguage> getUsers() {
        return users;
    }

    public void setUsers(Set<UserLanguage> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammingLang that = (ProgrammingLang) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
