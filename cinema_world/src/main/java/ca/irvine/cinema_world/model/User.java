package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    public long id;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_reservation",
        joinColumns = @JoinColumn(name = "reservation_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<Reservation> reservations = new HashSet<>();

    public String username;
    public String password;
    public String email;
    @Column(name = "phone_number")
    public String phoneNumber;
    @Column(name = "admin_right")
    public boolean adminRight;
}