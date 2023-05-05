package com.oyo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyo.Model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>
{

	List<Hotel> findByCity(String city);

}
