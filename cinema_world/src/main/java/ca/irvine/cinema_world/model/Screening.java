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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Screening { // TODO
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    @Id
    public int room_id;
    @Id
    public int film_id;
    public Date screenDay;
    public Time screenTime;

}