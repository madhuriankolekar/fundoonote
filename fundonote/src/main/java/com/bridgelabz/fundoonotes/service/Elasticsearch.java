package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.model.Note;

public interface Elasticsearch {
	String CreateNote(Note note);

	String UpdateNote(Note note);

	String DeleteNote(Note note);

	List<Note> searchbytitle(String title);


}
