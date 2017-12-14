package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"country", "city", "street", "houseNumber"})})
public class Cinema {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(columnDefinition = "VARCHAR2(50) NOT NULL")
    private String country;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String city;

    @Column(columnDefinition = "VARCHAR2(8)")
    private String district;

    @Column(columnDefinition = "VARCHAR2(50) NOT NULL")
    private String street;

    @Size(min = 1, max = 4)
    private byte houseNumber;

    @Column(columnDefinition = "VARCHAR2(20) NOT NULL")
    private String name;

    @Range(min = 0)
    @Column(columnDefinition = "SMALLINT DEFAULT 0")
    private short amenitiesCharge;

    // END OF DEFAULT COLUMNS

    @JsonManagedReference()
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cinema_film",
        joinColumns = @JoinColumn(name = "cinema_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "film_title")
    )
    private Set<Film> films = new HashSet<>();

    @JsonBackReference()
    @OneToMany(
        mappedBy = "cinemaId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Room> rooms = new ArrayList<>();

    @JsonManagedReference()
    @OneToMany(
        mappedBy = "cinemaId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Screening> screenings = new ArrayList<>();

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return the houseNumber
     */
    public byte getHouseNumber() {
        return houseNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the amenitiesCharge
     */
    public short getAmenitiesCharge() {
        return amenitiesCharge;
    }

    /**
     * @return the rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * @return the screenings
     */
    public List<Screening> getScreenings() {
        return screenings;
    }

    /**
     * @return the films
     */
    public Set<Film> getFilms() {
        return films;
    }

    /**
     * @param films the films to set
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}