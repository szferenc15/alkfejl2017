package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.irvine.cinema_inner_world.model.Ticket;
import ca.irvine.cinema_inner_world.repository.TicketRepository;
import ca.irvine.cinema_inner_world.util.Response;
import java.util.Optional;

@RestController
@RequestMapping("/world")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/ticket/update", method=RequestMethod.PATCH )
    public Response<String> updateCategory(@RequestParam("type") String type, @RequestParam("price") String price)
    {
        Optional<Ticket> new_ticket = ticketRepository.findByType(type);

        if(new_ticket.isPresent()){
            Ticket updated_ticket = new_ticket.get();

            updated_ticket.setPrice((short)Integer.parseInt(price));
            
            ticketRepository.save(updated_ticket);

            return Response.ok("OK");
        }
        return Response.error("Error");
    }
}