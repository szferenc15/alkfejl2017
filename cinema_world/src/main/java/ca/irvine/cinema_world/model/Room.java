package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @Column(name = "room_name")
    public String roomName;

    @OneToMany(
        mappedBy = "roomId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Screening> screenings = new ArrayList<>();

    @Column(name = "seat_number")
    public int seatNumber;
    public boolean imax;
    @Column(name = "four_dimensional")
    public boolean fourDimensional;
}