package com.lcwd.hotel.controller;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    // get single
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingle(@PathVariable String hotelId){
        Hotel hotel = hotelService.get(hotelId);
        return ResponseEntity.ok(hotel);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> allHotels = hotelService.getAll();
        return ResponseEntity.ok(allHotels);
    }
}
