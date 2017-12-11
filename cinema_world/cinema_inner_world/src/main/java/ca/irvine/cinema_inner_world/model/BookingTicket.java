package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"booking_id", "row", "chair"})})
public class BookingTicket {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(insertable = false, updatable = false, nullable = false) 
    private long id;

    @Column(columnDefinition = "VARCHAR2(20) NOT NULL DEFAULT 'BOOKING'")
    private String payment;

    @Range(min = 1, max = 20)
    private byte row;

    @Range(min = 1, max = 50)
    private byte chair;

    // END OF DEFAULT COLUMNS

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id")
    private Booking bookingId;

    @JsonManagedReference()
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_type", referencedColumnName = "type")
    private Ticket ticketType;

    @JsonBackReference()
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * @return the row
     */
    public byte getRow() {
        return row;
    }

    /**
     * @return the chair
     */
    public byte getChair() {
        return chair;
    }

    /**
     * @return the bookingId
     */
    public Booking getBookingId() {
        return bookingId;
    }

    /**
     * @return the ticketType
     */
    public Ticket getTicketType() {
        return ticketType;
    }

    /**
     * @return the username
     */
    public User getUsername() {
        return username;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * @param row the row to set
     */
    public void setRow(byte row) {
        this.row = row;
    }

    /**
     * @param chair the chair to set
     */
    public void setChair(byte chair) {
        this.chair = chair;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * @param ticketType the ticketType to set
     */
    public void setTicketType(Ticket ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(User username) {
        this.username = username;
    }
}