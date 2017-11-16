package ca.irvine.cinema_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import ca.irvine.cinema_world.model.Film;
import ca.irvine.cinema_world.repository.FilmRepository;
import ca.irvine.cinema_world.util.Response;

@RestController
@RequestMapping("/world")
public class FilmController{

    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(value= "/films", method=RequestMethod.POST )
    public Response<Iterable<Film>> getFilms()
    {
        Iterable<Film> optionalFilms = filmRepository.findAll();
        return Response.ok(optionalFilms);
    }
}