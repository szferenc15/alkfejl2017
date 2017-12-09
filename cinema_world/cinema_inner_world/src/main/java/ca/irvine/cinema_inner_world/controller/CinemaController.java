package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.irvine.cinema_inner_world.model.Cinema;
import ca.irvine.cinema_inner_world.repository.CinemaRepository;
import ca.irvine.cinema_inner_world.util.Response;

@RestController
@RequestMapping("/world")
public class CinemaController{

    @Autowired
    private CinemaRepository cinemaRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/cinemas", method=RequestMethod.GET )
    public Response<Iterable<Cinema>> getCinemas()
    {
        Iterable<Cinema> optionalCinemas = cinemaRepository.findAll();
        return Response.ok(optionalCinemas);
    }
}