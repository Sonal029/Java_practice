package com.masai.dto;

import java.time.LocalDate;

public interface Mobile {

	public String getModel(); 
	public void setModel(String model);
	public String getCompany();
	public void setCompany(String company);
	public int getPrice();
	public void setPrice(int price);
	public LocalDate getMfgDate();
	public void setMfgDate(LocalDate mfgDate);
	
	
}
