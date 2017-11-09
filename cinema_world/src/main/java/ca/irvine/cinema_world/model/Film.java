package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    public int id;

    //@OneToMany
    //@JoinColumn(name = "id")
    public int category_id;

    public String title;
    public boolean threeD;
    public int playTime;
    public Date premiere;
    public int ageLimit;
    public String directorFirstName;
    public String directorLastName;
    public String country;
    public int year;
    public String description;
}