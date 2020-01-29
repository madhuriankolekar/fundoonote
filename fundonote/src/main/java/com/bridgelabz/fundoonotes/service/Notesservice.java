package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.dto.Notesdto;
import com.bridgelabz.fundoonotes.model.Note;

public interface Notesservice {
	String create(Notesdto noteDTO,String tocken);
   boolean isUpdated(Integer id,Note note);
	List<Note> showAllNotes(String token);
	List<Note> getTrashed(String token);
	boolean trashed(String token,Long noteId);
boolean isDeleted(Integer noteId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * List<Note> showAllNotes(String token);
	
	List<Note> getArchieved(String token);
	
	List<Note> getTrashed(String token);
    
	List<Note> getPinned(String token);
	
	boolean trashed(String token,Long noteId);
	
	boolean restored(String token,Long noteId);
	
	boolean pinned(String token,Long noteId);
	
	boolean unPinned(String token,Long noteId);
	
	boolean archieved(String token,Long noteId);
	
	boolean unarchieved(String token,Long noteId);
	
	boolean remindMe(String token,Long noteId,LocalDateTime time);
	
	boolean setColor(String token,Long noteId,String color);
	



}
	 */
}
