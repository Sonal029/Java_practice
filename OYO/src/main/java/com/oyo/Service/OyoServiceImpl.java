package com.oyo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyo.Exception.OYOException;
import com.oyo.Model.Booking;
import com.oyo.Model.Customer;
import com.oyo.Model.Hotel;
import com.oyo.Model.RoomType;
import com.oyo.Model.Status;
import com.oyo.Repository.BookingRepository;
import com.oyo.Repository.CustomerRepository;
import com.oyo.Repository.HotelRepository;
import com.oyo.Repository.RoomTypeRepository;

@Service
public class OyoServiceImpl implements OyoService{

	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private HotelRepository hotelRepo;
	
	@Autowired
	private RoomTypeRepository roomTypeRepo;
	
	
	
	public Customer addCustomer(Customer customer)
	{
		Optional<Customer> existingCustomer = customerRepo.findById(customer.getCustomerId());
		if(existingCustomer.isPresent())
		{
			throw new OYOException("Customer Exists");
		}
		
		Customer newCustomer = customerRepo.save(customer);
		return newCustomer;
	}
	
	public Hotel addHotel(Hotel hotel)
	{
		Optional<Hotel> existingHotel = hotelRepo.findById(hotel.getHotelId());
		if(existingHotel.isPresent())
		{
			throw new OYOException("Hotel Exists");
		}
		Hotel newHotel = hotelRepo.save(hotel);
		return newHotel;
	}
	
	public Booking makeBooking(Integer CustomerId, Integer RoomId, LocalDate bookingDate)
	{
		Customer customer = customerRepo.findById(CustomerId).orElseThrow(()-> new OYOException("no customer found")) ;
        RoomType roomType = roomTypeRepo.findById(RoomId).orElseThrow(()->new OYOException("No roomType found")) ;
        
        
        Booking booking = new Booking();
        booking.setBookingDate(bookingDate);
        booking.setCustomer(customer);
        customer.getBookingList().add(booking) ;
        booking.setRoomType(roomType);
        roomType.getBookingList().add(booking) ;
        booking.setStatus(Status.PENDING);
   
        return bookingRepo.save(booking);
	}
	
	public RoomType createRoomType(Integer hotelId , RoomType roomType)
	{
		
		Optional<RoomType> existingRoomType = roomTypeRepo.findById(roomType.getRoomId());
		if(existingRoomType.isPresent())
		{
			throw new OYOException("Room type already exist");
		}
		Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new OYOException("No Hotel Found"));
		roomType.setHotel(hotel);
		 hotel.getList().add(roomType) ;
		return roomTypeRepo.save(roomType);
		
	}
	
	public Boolean updateBooking(String city, Integer roomId, Integer customerId)
	{
		Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new OYOException("Customer doesnot exist"));
		RoomType roomType1 = roomTypeRepo.findById(roomId).orElseThrow(()->new OYOException("No roomType found") ) ;
        List<Hotel> hotels = hotelRepo.findByCity(city) ;
        if(hotels.isEmpty()) throw new OYOException("no hotel found") ;
        List<RoomType> roomTypes = hotels.get(0).getList() ;
        if(roomTypes.isEmpty()) throw new OYOException("No room available") ;
        List<Booking> list = customer.getBookingList().stream().filter(a-> a.getRoomType().getRoomId() == roomId).toList();
        if(list.isEmpty()) throw new OYOException("No booking found") ;
        Booking booking = list.get(0) ;
        booking.setRoomType(roomType1);
        bookingRepo.save(booking) ;
        return  true ;
	}
	
	public List<Booking> getBooking(int customerId, LocalDate day1 , LocalDate day2) throws OYOException {
	        Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new OYOException("no customer exist"));
	        List<Booking> bookingList = bookingRepo.findByCustomerAndBookingDateBetween(customer,day1,day2) ;
	        if (bookingList.isEmpty()) throw new OYOException("No booking found") ;
	        return bookingList;
	    }

	public List<Hotel> getHotelList() throws OYOException {
	        List<Hotel> hotels = hotelRepo.findAll();
	        if(hotels.isEmpty()) throw new OYOException("No hotel is present");
	        return hotels;
	    }
	
}
