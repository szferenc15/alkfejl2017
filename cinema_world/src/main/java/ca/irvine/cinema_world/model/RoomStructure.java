package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "room_structure")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_name", referencedColumnName = "name")
    private Room roomName;
}