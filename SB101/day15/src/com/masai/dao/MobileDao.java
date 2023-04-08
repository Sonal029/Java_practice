package com.masai.dao;

import java.util.List;

import com.masai.dto.Mobile;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface MobileDao 
{
	public void addMobile(Mobile  mob) throws SomethingWentWrongException;
	public void updateMobile(Mobile mob) throws SomethingWentWrongException;
	public void DeleteMobile(String model) throws SomethingWentWrongException,NoRecordFoundException;
	
	public List<Mobile> SearchByModel(String model)throws NoRecordFoundException,SomethingWentWrongException;
	
	public List<Mobile> SearchByPrice(int lower_price , int higher_price)throws NoRecordFoundException,SomethingWentWrongException;

	
}
