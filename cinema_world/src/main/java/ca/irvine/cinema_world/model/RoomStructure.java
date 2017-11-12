package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_name", referencedColumnName = "name")
    public Cinema cinemaName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_name", referencedColumnName = "name")
    public Room roomName;

    public int row;
    public int seatNumber;
}