package app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@SuppressWarnings("FieldMayBeFinal")
public class Mentor extends User implements Serializable {

}
