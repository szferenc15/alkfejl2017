package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_inner_world.model.Cinema;
import java.util.Optional;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema,Integer>{
    Optional<Cinema> findById(int id);
    Optional<Cinema> findByCountry(String country);
    Optional<Cinema> findByCity(String city);
    Optional<Cinema> findByDistrictIsNotNull(String district);
    Optional<Cinema> findByStreet(String street);
    Optional<Cinema> findByName(String cinemaName);
    Iterable<Cinema> findAll();
}