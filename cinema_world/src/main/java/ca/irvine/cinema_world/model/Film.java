package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_name")
    public Cinema cinameName;

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
    public String language;
    public boolean synchron;
    public boolean inscriptive;
    public boolean imax;
    @Column(name = "three_dimensional")
    public boolean threeDimensional;
    @Column(name = "four_dimensional")
    public boolean fourDimensional;
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
    public BigDecimal rate;
    public String description;
}