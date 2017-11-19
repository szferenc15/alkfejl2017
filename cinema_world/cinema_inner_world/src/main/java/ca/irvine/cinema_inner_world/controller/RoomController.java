package ca.irvine.cinema_inner_world.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.irvine.cinema_inner_world.model.Room;
import ca.irvine.cinema_inner_world.repository.RoomRepository;
import ca.irvine.cinema_inner_world.util.Response;

@RestController
@RequestMapping("/world")
public class RoomController{

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value= "/rooms", method=RequestMethod.POST )
    public Response<Iterable<Room>> getRooms()
    {
        Iterable<Room> optionalRooms = roomRepository.findAll();
        return Response.ok(optionalRooms);
    }
}