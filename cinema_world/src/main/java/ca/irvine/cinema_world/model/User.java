package ca.irvine.cinema_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@lombok.Data
public class User {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_booking",
        joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
        inverseJoinColumns = @JoinColumn(name = "booking_id")
    )
    public Set<Booking> bookings = new HashSet<>();

    @Id
    public String username;
    public String password;
    public String email;
    public String phoneNumber;
    public boolean adminRight;
}