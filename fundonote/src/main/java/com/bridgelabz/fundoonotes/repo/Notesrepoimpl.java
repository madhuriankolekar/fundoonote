package com.bridgelabz.fundoonotes.repo;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.model.Note;

@Repository
public class Notesrepoimpl implements Notesrepo {
	@Autowired
	private EntityManager entityManager;
	//@Transactional
	@Override
	public Note createNote(Note note, Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
			note.setUserId(userId);//.setUserId(userId);
			Integer id;
			id = (Integer) currentSession.save(note);
			if (id != 0) {
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
	@Override
	public List<Note> getAllNotes(String token) {
	Long user_id = Long.valueOf(token);
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Note> query = currentSession.createQuery("from  where user_id=" + user_id, Note.class);
		List<Note> noteList = query.getResultList();
		return noteList;
	}
  @Override
	public Note getNoteById(Long noteId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		return note;
	}

@Override
public List<Note> getAllTrashed(List<User> userId) {
	Session currentSession = entityManager.unwrap(Session.class);
	Query<Note> query = currentSession.createQuery("from Note where user_id=" + userId + "and note_trash=true",
			Note.class);
	return query.getResultList();
	//return null;
}

@Override
public boolean setTrashed(List<User> userId, Long noteId) {
	Session currentSession=entityManager.unwrap(Session.class);
	Note note=getNoteById(noteId);
	if(note.getUserId().equals(userId)) 
	{
		if(!note.isTrashed()) {
		note.setTrashed(true);
		note.setUpdatedStamp(LocalDateTime.now());
		currentSession.save(note);
		return true;
	}
	
	return false;
}
	return false;

}

/*@Override
public Note createNote(Note note, List<User> user_id) {
	Session currentSession = entityManager.unwrap(Session.class);
	note.setUserId( user_id);
	//note.setUserId(user_id);//.setUserId(userId);
	Integer id;
	id = (Integer) currentSession.save(note);
	if (id != 0) {
		return note;
	}
	return null;

	
}*/
}




	















/************@Override
	public List<Note> getAllTrashed(Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Note> query = currentSession.createQuery("from Note where user_id=" + userId + "and note_trash=true",
				Note.class);
		return query.getResultList();
	}
	@Override
	public boolean setTrashed(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) 
		{
			if(!note.isTrashed()) {
			note.setTrashed(true);
			note.setUpdatedStamp(LocalDateTime.now());
			currentSession.save(note);
			return true;
		}
		
		
	
}
		return false;
}
}*/


	












