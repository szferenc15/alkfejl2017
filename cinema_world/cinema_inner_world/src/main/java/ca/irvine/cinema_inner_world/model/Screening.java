package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Screening {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    private boolean twoDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean threeDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean fourDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean imax;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String language;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    private boolean synchron;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean inscriptive;

    @Future
    private Date screenDay;

    @NotNull()
    private Time screenTime;

    // END OF DEFAULT COLUMNS

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;

    @JsonManagedReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room roomId;

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_title")
    private Film filmTitle;

    @JsonManagedReference()
    @OneToMany(
        mappedBy = "screeningId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Booking> bookings = new ArrayList<>();

    @JsonManagedReference()
    @OneToMany(
        mappedBy = "screeningId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<ScreeningTicket> availableTickets = new ArrayList<>();

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
    /**
     * @return the bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * @return the cinemaId
     */
    public Cinema getCinemaId() {
        return cinemaId;
    }

    /**
     * @return the filmTitle
     */
    public Film getFilmTitle() {
        return filmTitle;
    }

    /**
     * @return the roomId
     */
    public Room getRoomId() {
        return roomId;
    }

    /**
     * @return the twoDimensional
     */
    public boolean isTwoDimensional() {
        return twoDimensional;
    }

    /**
     * @return the threeDimensional
     */
    public boolean isThreeDimensional() {
        return threeDimensional;
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
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @return the synchron
     */
    public boolean isSynchron() {
        return synchron;
    }

    /**
     * @return the inscriptive
     */
    public boolean isInscriptive() {
        return inscriptive;
    }

    /**
     * @return the screenDay
     */
    public Date getScreenDay() {
        return screenDay;
    }

    /**
     * @return the screenTime
     */
    public Time getScreenTime() {
        return screenTime;
    }

    /**
     * @return the availableTickets
     */
    public List<ScreeningTicket> getAvailableTickets() {
        return availableTickets;
    }
}