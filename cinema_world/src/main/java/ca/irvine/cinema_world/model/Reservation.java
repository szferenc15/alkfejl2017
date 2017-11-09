package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Reservation { // TODO
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    //@ManyToMany
    //@JoinColumn(name = "id")
    public int user_id;

    //@OneToMany
    //@JoinColumn(name = "id")
    public int screen_id;

    public int numberOfReservation;
}