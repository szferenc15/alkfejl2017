package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ScreeningTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(insertable = false, updatable = false, nullable = false) 
    private long id;

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "screening_id")
    private Screening screeningId;

    @JsonManagedReference()
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_type", referencedColumnName = "type")
    private Ticket ticket;

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
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }
}