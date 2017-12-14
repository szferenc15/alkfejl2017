package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    // START OF DEFAULT COLUMNS

    @Id
    @Column(columnDefinition = "VARCHAR2(50)")
    private String title;

    @Column(columnDefinition = "VARCHAR2(50)")
    private String picture;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String language;

    @Range(min = 1, max = 300)
    private short playTime;

    @Future
    private Date premiere;

    @Range(min = 0, max = 21)
    @Column(columnDefinition = "TINYINT NOT NULL DEFAULT 12")
    private byte ageLimit;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String directorFirstName;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String directorLastName;

    @Column(columnDefinition = "VARCHAR2(50) NOT NULL")
    private String country;

    @Range(min = 1000, max = 9999)
    private short year;

    @DecimalMax("5.00")
    @DecimalMin("0.00")
    @Column(columnDefinition = "DECIMAL DEFAULT NULL", precision = 2)
    private BigDecimal rate;

    @Column(columnDefinition = "VARCHAR2(500) DEFAULT NULL")
    private String description;

    // END OF DEFAULT COLUMNS

    @JsonIgnoreProperties("films")
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "films", fetch = FetchType.EAGER)
    private Set<Cinema> cinemas = new HashSet<>();

    @JsonManagedReference
    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<FilmCategory> categories = new ArrayList<>();
    
    @JsonBackReference
    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Screening> screenings = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Trailer> trailers = new ArrayList<>();

    /**
     * @return the trailers
     */
    public List<Trailer> getTrailers() {
        return trailers;
    }

    /**
     * @return the categories
     */
    public List<FilmCategory> getCategories() {
        return categories;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * @return the year
     */
    public short getYear() {
        return year;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the directorLastName
     */
    public String getDirectorLastName() {
        return directorLastName;
    }

    /**
     * @return the directorFirstName
     */
    public String getDirectorFirstName() {
        return directorFirstName;
    }

    /**
     * @return the ageLimit
     */
    public byte getAgeLimit() {
        return ageLimit;
    }

    /**
     * @return the premiere
     */
    public Date getPremiere() {
        return premiere;
    }

    /**
     * @return the playTime
     */
    public short getPlayTime() {
        return playTime;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the cinemas
     */
    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    /**
     * @return the screenings
     */
    public List<Screening> getScreenings() {
        return screenings;
    }

    /**
     * @param cinemas the cinemas to set
     */
    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}