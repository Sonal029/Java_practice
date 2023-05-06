package com.oyo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyo.Model.Booking;
import com.oyo.Model.Customer;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>
{

	List<Booking> findByCustomerAndBookingDateBetween(Customer customer, LocalDate day1, LocalDate day2);

	
}
