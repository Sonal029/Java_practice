package com.oyo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.oyo.Exception.OYOException;
import com.oyo.Model.Booking;
import com.oyo.Model.Customer;
import com.oyo.Model.Hotel;
import com.oyo.Model.RoomType;
import com.oyo.Model.Status;

public interface OyoService {

	public Customer addCustomer(Customer customer);
	public Hotel addHotel(Hotel hotel);
	
	public Booking makeBooking(Integer CustomerId, Integer RoomId, LocalDate bookingDate);
	
	public RoomType createRoomType(Integer hotelId , RoomType roomType);
	public Boolean updateBooking(String city, Integer roomId, Integer customerId);
	
	public List<Booking> getBooking(int customerId, LocalDate day1 , LocalDate day2) throws OYOException;

	public List<Hotel> getHotelList() throws OYOException ;
}
