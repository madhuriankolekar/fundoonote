package com.bridgelabz.fundoonotes.service;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.Notesdto;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.repo.Notesrepo;

@Service
public class Noteserviceimpl implements Notesservice {
	
	
	
	@Autowired	
	private  Notesrepo notesrepo;
	@Transactional
	@Override
	public boolean  isCreated(Notesdto notedtO) {
		Note note = noteDTOToNote(notedtO);
		Note noteObj =notesrepo.createNote(note);
		if (noteObj != null) {
		return true;
	}
		return false;
	}
	@Transactional
	private Note noteDTOToNote(Notesdto notedtO) {
		Note note = new Note();
		note.setColor(null);
		note.setPinned(false);
		note.setId(null);
		note.setColor(null);
		note.setCreatedStamp(LocalDateTime.now());
		note.setUpdatedStamp(LocalDateTime.now());
		note.setRemaindMe(LocalDateTime.now());
		return null;
	}
	@Transactional
	@Override
	public boolean isUpdated(Integer id, Notesdto notedtO) {
		Note note = notesrepo.getNoteById(id);
		if (notedtO.getTitle()!= null)
		{
			note.setTitle(null);
		}
		if (notedtO.getDescription()!=null)
		{
			note.setDescription(null);   
		}
       note.setUpdatedStamp(null); 
		if (notesrepo.updateNote(id, note) != null) {
		{return true;
		}
		return false;
		}

	@Override
	public boolean isDeleted(Integer noteId) {
		
		return false;
	}
	
	
}
