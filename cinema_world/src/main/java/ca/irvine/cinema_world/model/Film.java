package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
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
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    // START OF DEFAULT COLUMNS

    @Id
    @Column(columnDefinition = "VARCHAR2(50)")
    private String title;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String language;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    private boolean synchron;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean inscriptive;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean imax;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean threeDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean fourDimensional;

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

    @DecimalMax("10.00")
    @DecimalMin("0.00")
    @Column(columnDefinition = "DECIMAL DEFAULT NULL", precision = 2, insertable = false)
    private BigDecimal rate;

    @Column(columnDefinition = "VARCHAR2(500) DEFAULT NULL")
    private String description;

    // END OF DEFAULT COLUMNS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;

    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<FilmCategory> categories = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "filmTitle",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Screening> screenings = new ArrayList<>();

    
}