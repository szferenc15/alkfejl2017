package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.irvine.cinema_inner_world.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer>{
    @Query(value = "SELECT * FROM Booking WHERE id = :screeningId", nativeQuery = true)
    Iterable<Booking> findTickets(@Param("screeningId") String screeningId);
    Iterable<Booking> findAll();
}