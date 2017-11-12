package ca.irvine.cinema_world.model;

import lombok.Data;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}