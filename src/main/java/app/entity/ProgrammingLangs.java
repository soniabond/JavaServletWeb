package app.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "programming_langs")
public class ProgrammingLangs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "programmingLangs")
    @SuppressWarnings("FieldMayBeFinal")
    private Set<User> users = new HashSet<>();
}
