package com.court.DAO;

import java.util.List;

import com.court.DTO.Lawyer;
import com.court.Exception.SomethingWentWrongException;

public interface LawyerDAO {

	public void addLAwyer(Lawyer l) throws SomethingWentWrongException;
	public void updateLAwyer(Lawyer l) throws SomethingWentWrongException;
	public void deleteLAwyer(int id) throws SomethingWentWrongException;
	public List<Lawyer> viewLawyer() throws SomethingWentWrongException;
}
