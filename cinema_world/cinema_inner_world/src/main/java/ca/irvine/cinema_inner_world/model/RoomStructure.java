package ca.irvine.cinema_inner_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class RoomStructure {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Range(min = 1, max = 20)
    private byte row;

    @Range(min = 1, max = 50)
    private byte seatNumber;

    // END OF DEFAULT COLUMNS

    @JsonBackReference()
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room roomId;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the row
     */
    public byte getRow() {
        return row;
    }
    
    /**
     * @return the seatNumber
     */
    public byte getSeatNumber() {
        return seatNumber;
    }

    /**
     * @return the cinemaId
     */
    public Cinema getCinemaId() {
        return cinemaId;
    }

    /**
     * @return the roomId
     */
    public Room getRoomId() {
        return roomId;
    }
}