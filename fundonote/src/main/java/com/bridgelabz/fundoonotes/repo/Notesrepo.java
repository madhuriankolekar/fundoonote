package com.bridgelabz.fundoonotes.repo;
import java.util.List;

import org.apache.catalina.User;

import com.bridgelabz.fundoonotes.model.Note;
public interface Notesrepo {
    
	Note createNote(Note note,Long user_id);
	//Note createNote(Note note,Long userId);
	Note updateNote(Integer noteId,Note note);
	Note getNoteById(Long noteId);
	List<Note> getAllNotes(String token);
	List<Note> getAllTrashed(List<User> userId);
	//List<Note> getAllTrashed(Long userId);
	//boolean setTrashed(Long userId,Long noteId);
	
	boolean setTrashed(List<User> userId,Long noteId);
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
