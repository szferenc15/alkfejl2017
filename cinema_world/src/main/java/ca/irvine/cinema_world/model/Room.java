package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_name")
    public Cinema cinemaName;

    @Column(unique = true)
    public String name;

    @OneToMany(
        mappedBy = "roomId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Screening> screenings = new ArrayList<>();

    @OneToMany(
        mappedBy = "roomName",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<RoomStructure> structure = new ArrayList<>();

    public boolean vip;
    public boolean bedRoom;
    public boolean imax;
    public boolean threeDimensional;
    public boolean fourDimensional;
}