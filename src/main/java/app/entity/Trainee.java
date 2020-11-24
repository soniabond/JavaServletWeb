package app.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trainees")
@DiscriminatorValue("TR")
public class Trainee extends User{
}
