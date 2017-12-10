package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(columnDefinition = "VARCHAR2(20)", unique = true)
    private String name;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean vip;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean bedRoom;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean imax;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean threeDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean fourDimensional;

    @Size(min = 1, max = 20)
    private byte row;

    @Size(min = 1, max = 50)
    private byte seatNumber;
    
    // END OF DEFAULT COLUMNS

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;

    @JsonBackReference()
    @OneToMany(
        mappedBy = "roomId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Screening> screenings = new ArrayList<>();

    /**
     * @return the cinemaId
     */
    public Cinema getCinemaId() {
        return cinemaId;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the screenings
     */
    public List<Screening> getScreenings() {
        return screenings;
    }

    /**
     * @return the bedRoom
     */
    public boolean isBedRoom() {
        return bedRoom;
    }

    /**
     * @return the fourDimensional
     */
    public boolean isFourDimensional() {
        return fourDimensional;
    }

    /**
     * @return the imax
     */
    public boolean isImax() {
        return imax;
    }

    /**
     * @return the threeDimensional
     */
    public boolean isThreeDimensional() {
        return threeDimensional;
    }

    /**
     * @return the seatNumber
     */
    public byte getSeatNumber() {
        return seatNumber;
    }

    /**
     * @return the row
     */
    public byte getRow() {
        return row;
    }
}