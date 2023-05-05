package com.oyo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyo.Model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>
{

	
}
