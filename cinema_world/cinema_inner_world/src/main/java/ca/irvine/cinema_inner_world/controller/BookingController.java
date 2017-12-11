package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ca.irvine.cinema_inner_world.model.Booking;
import ca.irvine.cinema_inner_world.model.BookingTicket;
import ca.irvine.cinema_inner_world.model.Screening;
import ca.irvine.cinema_inner_world.model.User;
import ca.irvine.cinema_inner_world.repository.BookingRepository;
import ca.irvine.cinema_inner_world.repository.BookingTicketRepository;
import ca.irvine.cinema_inner_world.repository.ScreeningRepository;
import ca.irvine.cinema_inner_world.repository.TicketRepository;
import ca.irvine.cinema_inner_world.repository.UserRepository;
import ca.irvine.cinema_inner_world.util.Response;

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
    @RequestMapping(value= "/new_booking", method=RequestMethod.GET )
    public Response<String> insertBooking( @RequestParam(value="tickets")  String tickets,
                                           @RequestParam(value="screeningId") Long screeningId)
    {
        Booking booking = new Booking();
        booking.setScreeningId(screeningRepository.findById(screeningId).get());
        bookingRepository.save(booking);

        BookingTicket bookingTicket = new BookingTicket();

        String[] info = tickets.split(" ");
        bookingTicket.setUsername(userRepository.findByUsername(info[0]).get());
        bookingTicket.setBookingId(booking);
        bookingTicket.setPayment("Booking");
        bookingTicket.setTicketType(ticketRepository.findByType("IMAX 3D Normal").get());
        bookingTicket.setRow((byte)5);
        bookingTicket.setChair((byte)12);

        bookingTicketRepository.save(bookingTicket);

        BookingTicket bookingTicket2 = new BookingTicket();

        bookingTicket2.setUsername(userRepository.findByUsername(info[1]).get());
        bookingTicket2.setBookingId(booking);
        bookingTicket2.setPayment("Booking");
        bookingTicket2.setTicketType(ticketRepository.findByType("IMAX 3D Normal").get());
        bookingTicket2.setRow((byte)6);
        bookingTicket2.setChair((byte)12);

        bookingTicketRepository.save(bookingTicket2);
 
        
        return Response.ok("OK");
    }
}