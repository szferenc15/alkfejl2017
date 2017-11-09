package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Screening { // TODO
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    public int id;

    //@OneToMany
    //@JoinColumn(name = "id")
    public int room_id;

    //@OneToMany
    //@JoinColumn(name = "id")
    public int film_id;

    public Date screenDay;
    public Time screenTime;

}