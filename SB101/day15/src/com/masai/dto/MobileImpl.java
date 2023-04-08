package com.masai.dto;

import java.time.LocalDate;

public class MobileImpl implements Mobile
{
	private String model;
	private String company;
	private int price;
	private LocalDate mfgDate;
	public MobileImpl(String model, String company, int price, LocalDate mfgDate) {
		super();
		this.model = model;
		this.company = company;
		this.price = price;
		this.mfgDate = mfgDate;
	}
   @Override
	public String getModel() {
		return model;
	}
   @Override
	public void setModel(String model) {
		this.model = model;
	}
   @Override
	public String getCompany() {
		return company;
	}
   @Override
	public void setCompany(String company) {
		this.company = company;
	}
   @Override
	public int getPrice() {
		return price;
	}
   @Override
	public void setPrice(int price) {
		this.price = price;
	}
   @Override
	public LocalDate getMfgDate() {
		return mfgDate;
	}
   @Override
	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}
	
	

}
