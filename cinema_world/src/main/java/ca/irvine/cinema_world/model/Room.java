package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    public int id;
    public int seatNumber;
    public boolean IMAX;
    public boolean fourD;
}