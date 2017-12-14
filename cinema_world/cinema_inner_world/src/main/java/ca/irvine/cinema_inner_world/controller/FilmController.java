package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.irvine.cinema_inner_world.model.Film;
import ca.irvine.cinema_inner_world.repository.FilmRepository;
import ca.irvine.cinema_inner_world.util.Response;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/world")
public class FilmController{

    @Autowired
    private FilmRepository filmRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/films", method=RequestMethod.GET )
    public Response<Iterable<Film>> getFilms()
    {
        Iterable<Film> optionalFilms = filmRepository.findAll();
        return Response.ok(optionalFilms);
    }

    @PersistenceContext protected EntityManager entityManager;
    @Transactional
    @RequestMapping(value= "/films/delete", method=RequestMethod.DELETE )
    public Response<String> deleteFilm(@RequestParam("title") String title)
    {     
      
        int isSuccessful = entityManager.createQuery("DELETE FROM Film f where f.title= :title")
                .setParameter("title", title)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new OptimisticLockException("Modification completed");
        }

        return Response.ok("OK");
    }
}