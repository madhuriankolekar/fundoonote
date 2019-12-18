package com.bridgelabz.fundoonotes.repo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.fundoonotes.model.Note;

@Repository
public class Notesrepoimpl implements Notesrepo {
	@Autowired
	private EntityManager entityManager;
	@Transactional
	@Override
	public Note createNote(Note note) {
		Session currentSession = entityManager.unwrap(Session.class);
		Integer id;
		//System.out.println();
		id = (Integer)currentSession.save(note);
		System.out.println(id);
		if (id != 0) {
			return note;
		}
		return null;

	}

	@Transactional
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
		return note;

	}

	@Override
	public Note getNoteById(Integer noteId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		return note;
	}

	@Transactional
	@Override
	public List<Note> getAllNotes() {
		
		return null;
	}

	/*@Override
	public List<Note> getAllNotes() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("select *from Note ",Note.class);//.createQuery(toString()); // .createQuery("from User", Note.class);
		List<Note> noteList = query.getR//.getR//.getResultList();
		return noteList;

	}*/

}

