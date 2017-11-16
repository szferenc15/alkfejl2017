package ca.irvine.cinema_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_world.model.Room;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room,Integer>{
    Optional<Room> findById(int id);
    Optional<Room> findByName(String name);
    Optional<Room> findByVip(boolean isVip);
    Optional<Room> findByBedRoom(boolean isBedRoom);
    Optional<Room> findByImax(boolean isImax);
    Optional<Room> findByThreeDimensonal(boolean isThreeDimensonal);
    Optional<Room> findByFourDimensonal(boolean isFourDimensonal);
    Iterable<Room> findAll();
}