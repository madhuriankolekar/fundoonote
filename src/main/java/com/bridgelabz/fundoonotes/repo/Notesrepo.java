package com.bridgelabz.fundoonotes.repo;
import com.bridgelabz.fundoonotes.model.Note;
public interface Notesrepo {
     Note createNote(Note note);
	
	Note updateNote(Integer noteId,Note note);
	
	//Note deleteNote(Integer noteId);
	
	//Note getNoteById(Integer noteId);

	///List<Note> getAllNotes();
	


}
