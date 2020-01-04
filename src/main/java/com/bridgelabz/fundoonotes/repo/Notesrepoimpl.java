package com.bridgelabz.fundoonotes.repo;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.model.Note;

@Repository
public class Notesrepoimpl implements Notesrepo {
	@Autowired
	private EntityManager entityManager;
	@Transactional
	@Override
	public Note createNote(Note note) {
		Session currentSession=entityManager.unwrap(Session.class);
		int status=0;
		status=(int) currentSession.save( note);
		if(status!=0) {
			return note;
		}
		return null;
		}
	@Transactional
	public Note save(Note note)
	{int status = 0;
	Session session = entityManager.unwrap(Session.class);
	status = (int) session.save( note);
	if (status != 0)
	{
	
	return note;
	}
	return null;
	}
	@Transactional
	@Override
	public Note updateNote(Integer noteId, Note note) {
		Session currentSession=entityManager.unwrap(Session.class);
		Label notesObj=currentSession.get(Label.class, noteId);
		if(notesObj!=null) {
			currentSession.update(note);
		return note;
	}
		return null;
	}
}


	/*@Transactional
	@Override
	public Note updateNote(Integer noteId,Note note) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note noteObj = currentSession.get(Note.class, noteId);
		if(noteObj!=null) {
			currentSession.update(note);
			return note;
		}
		return noteObj;

	}

	@Transactional
	@Override
	public Note deleteNote(Integer noteId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		if(note!=null) {
		  currentSession.delete(note);
		  return note;
		}
		return null;

	}

	@Override
	public Note getNoteById(Integer noteId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		return note;
	}

	/*@Transactional
	@Override
	public List<Note> getAllNotes() {
		
		return null;
	}*/



