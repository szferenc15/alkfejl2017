package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Data
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

    @OneToMany(
        mappedBy = "cinemaName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(
        mappedBy = "cinemaName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Film> films = new ArrayList<>();

    @OneToMany(
        mappedBy = "cinemaName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Screening> screenings = new ArrayList<>();
}