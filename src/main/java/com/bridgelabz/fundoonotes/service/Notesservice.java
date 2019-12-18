package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.Notesdto;

public interface Notesservice {
boolean  isCreated(Notesdto notedtO);
	
	boolean isUpdated(Integer id,Notesdto notedtO);
	
	boolean isDeleted(Integer noteId);
}
