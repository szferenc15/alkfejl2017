package ca.irvine.cinema_world.model;

import lombok.Data;
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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    public Room roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    public Film filmId;

    @OneToMany(
        mappedBy = "screeningId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Reservation> reservations = new ArrayList<>();

    @Column(name = "screen_day")
    public Date screenDay;
    @Column(name = "screen_time")
    public Time screenTime;

}