package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ca.irvine.cinema_inner_world.model.Room;
import ca.irvine.cinema_inner_world.repository.RoomRepository;
import ca.irvine.cinema_inner_world.util.Response;

@RestController
@RequestMapping("/rooms")
public class RoomController{

    @Autowired
    private RoomRepository roomRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value= "/room_dimension", method=RequestMethod.GET )
    public Response<Iterable<Room>> getRoomDimension(@RequestParam(value="roomId") Long roomId)
    {
        Iterable<Room> optionalRoomDimension = roomRepository.findRoomDimensionByRoomId(roomId);
        return Response.ok(optionalRoomDimension);
    }
}