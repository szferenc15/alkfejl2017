package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import ca.irvine.cinema_inner_world.model.Screening;
import ca.irvine.cinema_inner_world.repository.ScreeningRepository;
import ca.irvine.cinema_inner_world.util.Response;

@RestController
@RequestMapping("/world")
public class ScreeningController{

    @Autowired
    private ScreeningRepository screeningRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/screenings", method=RequestMethod.GET )
    public Response<Iterable<Screening>> getScreenings()
    {
        Iterable<Screening> optionalScreenings = screeningRepository.findAll();
        return Response.ok(optionalScreenings);
    }
}