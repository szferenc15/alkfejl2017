package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ca.irvine.cinema_inner_world.model.Room;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room,Integer>{
    @Query("SELECT new map(row as row, seatNumber as seatNumber) FROM Room WHERE id = :roomId")
    Iterable<Room> findRoomDimensionByRoomId(@Param("roomId") Long roomId);
    Optional<Room> findById(int id);
    Optional<Room> findByName(String name);
    Optional<Room> findByVip(boolean isVip);
    Optional<Room> findByBedRoom(boolean isBedRoom);
    Optional<Room> findByImax(boolean isImax);
    Optional<Room> findByThreeDimensional(boolean isThreeDimensional);
    Optional<Room> findByFourDimensional(boolean isFourDimensional);
    Iterable<Room> findAll();
}