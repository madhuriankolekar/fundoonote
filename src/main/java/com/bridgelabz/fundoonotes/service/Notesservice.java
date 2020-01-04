package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.Notesdto;
import com.bridgelabz.fundoonotes.model.Note;

public interface Notesservice {
     boolean  isCreated(Notesdto notedtO);
	
	boolean isUpdated(Integer id,Note note);
	
///	boolean isDeleted(Integer noteId);
}
