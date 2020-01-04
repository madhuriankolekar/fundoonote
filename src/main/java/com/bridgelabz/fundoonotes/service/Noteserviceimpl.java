package com.bridgelabz.fundoonotes.service;
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
			String d=notedtO.getDescription();
		return true;
	}
		return false;
	}
	
	@Transactional
	private Note noteDTOToNote(Notesdto notedtO) {
		Note notes = new Note();
		notes.setDescription(notedtO.getDescription());
		notes.setTitle(notedtO.getTitle());
		return notes;
		
	}
	@Transactional
	@Override
	public boolean isUpdated(Integer id, Note note) {
		
		return false;
	}
	 
}

