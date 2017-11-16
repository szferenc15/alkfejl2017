package ca.irvine.cinema_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.irvine.cinema_world.model.Cinema;
import ca.irvine.cinema_world.repository.CinemaRepository;


import ca.irvine.cinema_world.util.Response;

@RestController
@RequestMapping("/world")
public class CinemaController{

    @Autowired
    private CinemaRepository cinemaRepository;

    @RequestMapping(value= "/cinemas", method=RequestMethod.POST )
    public Response<Iterable<Cinema>> getCinemas()
    {
        Iterable<Cinema> optionalCinemas = cinemaRepository.findAll();
        return Response.ok(optionalCinemas);
    }
}