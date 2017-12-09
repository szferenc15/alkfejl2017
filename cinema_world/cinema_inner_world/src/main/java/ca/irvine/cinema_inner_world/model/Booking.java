package ca.irvine.cinema_inner_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonBackReference()
    @ManyToMany(mappedBy = "bookings", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();
    
    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "screening_id")
    private Screening screeningId;

    @JsonManagedReference()
    @OneToMany(
        mappedBy = "bookingId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<BookingTicket> tickets = new ArrayList<>();

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the screeningId
     */
    public Screening getScreeningId() {
        return screeningId;
    }

    /**
     * @return the tickets
     */
    public List<BookingTicket> getTickets() {
        return tickets;
    }
}