package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ca.irvine.cinema_inner_world.model.Booking;
import ca.irvine.cinema_inner_world.repository.BookingRepository;
import ca.irvine.cinema_inner_world.util.Response;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/tickets", method=RequestMethod.GET )
    public Response<Iterable<Booking>> getOccupiedChairs(@RequestParam(value="screeningId") String screeningId)
    {
        Iterable<Booking> optionalTickets = bookingRepository.findTickets(screeningId);
        return Response.ok(optionalTickets);
    }
}