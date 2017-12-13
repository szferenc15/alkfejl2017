package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ca.irvine.cinema_inner_world.model.Booking;
import ca.irvine.cinema_inner_world.model.BookingTicket;
import ca.irvine.cinema_inner_world.repository.BookingRepository;
import ca.irvine.cinema_inner_world.repository.BookingTicketRepository;
import ca.irvine.cinema_inner_world.repository.ScreeningRepository;
import ca.irvine.cinema_inner_world.repository.TicketRepository;
import ca.irvine.cinema_inner_world.repository.UserRepository;
import ca.irvine.cinema_inner_world.util.Response;

class BookingType {
    private String ticketType;
    private String row;
    private String chair;

    /**
     * @return the ticketType
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * @return the row
     */
    public String getRow() {
        return row;
    }

    /**
     * @return the chair
     */
    public String getChair() {
        return chair;
    }
}

class BookingRequest {
    private Long screeningId;
    private String username;
    private String paymentMethod;
    private BookingType[] bookings;

    /**
     * @return the screeningId
     */
    public Long getScreeningId() {
        return screeningId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @return the bookings
     */
    public BookingType[] getBookings() {
        return bookings.clone();
    }
}

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    BookingTicketRepository bookingTicketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/tickets", method=RequestMethod.GET )
    public Response<Iterable<Booking>> getOccupiedChairs(@RequestParam(value="screeningId") String screeningId)
    {
        Iterable<Booking> optionalTickets = bookingRepository.findTickets(screeningId);
        return Response.ok(optionalTickets);
    }

    @CrossOrigin("http://localhost:4200")
    @Transactional
    @RequestMapping(value= "/new_booking", method=RequestMethod.POST, consumes = "application/json")
    public Response<String> insertBooking(@RequestBody BookingRequest bookingRequest)
    {
        Booking booking = new Booking();
        booking.setScreeningId(screeningRepository.findById(bookingRequest.getScreeningId()).get());
        bookingRepository.save(booking);
        
        BookingType[] bookingType = bookingRequest.getBookings();
        for (int i = 0; i < bookingType.length; i++) {
            BookingTicket bookingTicket = new BookingTicket();
            bookingTicket.setUsername(userRepository.findByUsername(bookingRequest.getUsername()).get());
            bookingTicket.setBookingId(booking);
            bookingTicket.setPayment(bookingRequest.getPaymentMethod());
            bookingTicket.setTicketType(ticketRepository.findByType(bookingType[i].getTicketType()).get());
            bookingTicket.setRow((byte)Integer.parseInt(bookingType[i].getRow()));
            bookingTicket.setChair((byte)Integer.parseInt(bookingType[i].getChair()));
            bookingTicketRepository.save(bookingTicket);
        }
 
        return Response.ok("OK");
    }
}