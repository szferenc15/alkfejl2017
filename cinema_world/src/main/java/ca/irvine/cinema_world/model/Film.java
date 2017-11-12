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
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_name", referencedColumnName = "name")
    public Cinema cinemaName;

    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<CategoryInformation> categories = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Screening> screenings = new ArrayList<>();

    @Id
    public String title;
    public String language;
    public boolean synchron;
    public boolean inscriptive;
    public boolean imax;
    public boolean threeDimensional;
    public boolean fourDimensional;
    public int playTime;
    public Date premiere;
    public int ageLimit;
    public String directorFirstName;
    public String directorLastName;
    public String country;
    public int year;
    public BigDecimal rate;
    public String description;
}