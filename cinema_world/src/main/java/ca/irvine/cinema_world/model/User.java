package ca.irvine.cinema_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class User {
    // START OF DEFAULT COLUMNS

    // ------ TODO: RegExp is ignored for first insertation ------

    @Id
    @Pattern(regexp="^[a-z0-9_-]{3,15}$", message = "Username validation failed")
    @Column(columnDefinition = "VARCHAR2(15)")
    private String username;

    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,42}$", message = "Password validation failed")
    @Column(columnDefinition = "VARCHAR2(42)")
    private String password;

    @Pattern(regexp="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$", message = "Email validation failed")
    @Column(columnDefinition = "VARCHAR2(50)", unique = true)
    private String email;

    @Pattern(regexp="^\\+?[0-9]{7,14}$")
    @Column(columnDefinition = "VARCHAR2(14)")
    private String phoneNumber;
    
    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean adminRight;

    // END OF DEFAULT COLUMNS

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_booking",
        joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
        inverseJoinColumns = @JoinColumn(name = "booking_id")
    )
    private Set<Booking> bookings = new HashSet<>();

    // ------ TODO: Lombok Data is not working (ignored) ------

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

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * @return the bookings
     */
    public Set<Booking> getBookings() {
        return bookings;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
}