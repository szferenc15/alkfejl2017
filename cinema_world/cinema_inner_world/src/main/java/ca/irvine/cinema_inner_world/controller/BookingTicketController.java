package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import ca.irvine.cinema_inner_world.model.BookingTicket;
import ca.irvine.cinema_inner_world.repository.BookingTicketRepository;
import ca.irvine.cinema_inner_world.util.Response;

@RestController
@RequestMapping("/booking/ticket")
public class BookingTicketController {

    @Autowired
    private BookingTicketRepository bookingTicketRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/occupied_chairs", method=RequestMethod.GET )
    public Response<Iterable<BookingTicket>> getOccupiedChairs()
    {
        Iterable<BookingTicket> optionalOccupiedChairs = bookingTicketRepository.findOccupiedChair();
        return Response.ok(optionalOccupiedChairs);
    }
}