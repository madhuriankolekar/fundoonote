package com.bridgelabz.fundoonotes.service;
import com.bridgelabz.fundoonotes.dto.Labeldto;
public interface Labelservice {
	boolean isCreated(Labeldto labelDTO);
	boolean isDeleted(Integer labelId);
	boolean isUpadated(Integer labelId,Labeldto labelDTO);
}
