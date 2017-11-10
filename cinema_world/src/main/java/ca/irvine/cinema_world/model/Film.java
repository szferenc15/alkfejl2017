package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @OneToMany(
        mappedBy = "filmId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Category> categories = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "filmId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Screening> screenings = new ArrayList<>();
    
    public String title;
    @Column(name = "three_dimensional")
    public boolean threeDimensional;
    @Column(name = "play_time")
    public int playTime;
    public Date premiere;
    @Column(name = "age_limit")
    public int ageLimit;
    @Column(name = "director_first_name")
    public String directorFirstName;
    @Column(name = "director_last_name")
    public String directorLastName;
    public String country;
    public int year;
    public String description;
}