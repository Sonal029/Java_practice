package com.oyo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.Model.Booking;
import com.oyo.Model.Customer;
import com.oyo.Model.Hotel;
import com.oyo.Model.RoomType;
import com.oyo.Service.OyoService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
public class OyoController {
	
	@Autowired
	private OyoService oyoService;

	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<>(oyoService.addCustomer(customer) ,HttpStatus.CREATED);
	}
	
	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotelHandler(@Valid @RequestBody Hotel hotel)
	{
		return new ResponseEntity<>(oyoService.addHotel(hotel), HttpStatus.CREATED);
	}
	
	@PostMapping("/bookings/{customerId}/{roomId}/{bookingDate}")
	public ResponseEntity<Booking> addBooking(@PathVariable Integer customerId ,@PathVariable Integer roomId ,@PathVariable LocalDate bookingDate)
	{
		return new ResponseEntity<>(oyoService.makeBooking(customerId, roomId, bookingDate),HttpStatus.CREATED);
	}
	
	@PostMapping("/roomTypes/{hotelId}")
	public ResponseEntity<RoomType> addRoomType(@Valid @PathVariable Integer hotelId, @RequestBody RoomType roomType)
	{
		return new ResponseEntity<>(oyoService.createRoomType(hotelId, roomType),HttpStatus.CREATED);
	}
	
	@PutMapping("/bookings/{city}/{roomId}/{customerId}")
	public ResponseEntity<Boolean> updateBooking(@PathVariable String city, @PathVariable Integer roomId, @PathVariable Integer customerId)
	{
		return new ResponseEntity<>(oyoService.updateBooking(city, roomId, customerId),HttpStatus.OK);
	}
	
	@GetMapping("/bookings/{customerId}/{day1}/{day2}")
	public ResponseEntity<List<Booking>> getBookingByDateHandler(@PathVariable Integer customerId,@PathVariable LocalDate day1 ,@PathVariable LocalDate day2)
	{
		List<Booking> bookingList = oyoService.getBooking(customerId, day1, day2);
		return new ResponseEntity<>(bookingList , HttpStatus.OK);
	}
	
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getHotelList()
	{
		return new ResponseEntity<>(oyoService.getHotelList(), HttpStatus.OK);
	}
}
