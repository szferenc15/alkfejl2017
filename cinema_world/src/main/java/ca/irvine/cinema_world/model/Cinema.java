package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    public String country;
    public String city;
    public String district;
    public String street;
    public String houseNumber;
    @Column(unique = true)
    public String name;
    public int amenitiesCharge;

    @OneToMany(
        mappedBy = "cinemaName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Room> rooms = new ArrayList<>();

    @OneToMany(
        mappedBy = "cinemaName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Film> films = new ArrayList<>();

    @OneToMany(
        mappedBy = "cinemaName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Screening> screenings = new ArrayList<>();
}