package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"booking_id", "row", "chair"})})
public class TicketInformation {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(columnDefinition = "VARCHAR2(20) NOT NULL DEFAULT 'BOOKING'")
    private String payment;

    @Range(min = 1, max = 20)
    private byte row;

    @Range(min = 1, max = 50)
    private byte chair;

    // END OF DEFAULT COLUMNS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking bookingId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type", referencedColumnName = "type")
    private Ticket ticket;
}