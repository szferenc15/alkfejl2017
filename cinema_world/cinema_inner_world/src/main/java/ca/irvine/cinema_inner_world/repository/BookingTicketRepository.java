package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_inner_world.model.BookingTicket;

@Repository
public interface BookingTicketRepository extends CrudRepository<BookingTicket,Integer>{
    @Query("SELECT new map(row as row, chair as chair) FROM BookingTicket")
    Iterable<BookingTicket> findOccupiedChair();
    Iterable<BookingTicket> findAll();
}