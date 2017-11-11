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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_booking",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<Booking> bookings = new HashSet<>();

    public String username;
    public String password;
    public String email;
    public String phoneNumber;
    public boolean adminRight;

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}