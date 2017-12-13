package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_inner_world.model.Ticket;
import java.util.Optional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer>{
    Optional<Ticket> findByType(String type);
}