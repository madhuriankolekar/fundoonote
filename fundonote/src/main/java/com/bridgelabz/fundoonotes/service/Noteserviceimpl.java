package com.bridgelabz.fundoonotes.service;
import java.util.List;
import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.fundoonotes.dto.Notesdto;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.repo.Notesrepo;

@Service
public class Noteserviceimpl implements Notesservice {
	@Autowired	
	private  Notesrepo notesrepo;
	@Autowired
	private WebClientService webClientService;
	@Transactional
		@Override
		public String create(Notesdto noteDTO, String tocken) {
			Long user_id = webClientService.getUserId(tocken);
				if (user_id != 0) {
					Note note = noteDTOToNote(noteDTO);
					Note noteObj =  notesrepo.createNote(note, user_id);
					if (noteObj != null) {
						return "Note is Created";
					}
				}
				return "Note is not Created";
			
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
	 @Transactional
	public List<Note> showAllNotes(String token) {
		
		List<Note> noteList =notesrepo.getAllNotes(token);//.getAllNotes(token);
		if (noteList != null) {
			return noteList;
		}
		return null;
	}
	/*@Override
	public String create(Notesdto noteDTO, String tocken) {
		List<User> user_id = webClientService.getUserId(tocken);
	if (user_id !=null) {
			Note note = noteDTOToNote(noteDTO);
			Note noteObj =  notesrepo.createNote(note, user_id);
			if (noteObj != null) {
				return "Note is Created";
			}
		
		return "Note is not Created";
		//return null;
	}
	return null;
	}*/
	@Override
	public List<Note> getTrashed(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean trashed(String token, Long noteId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isDeleted(Integer noteId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/* @Transactional
	@Override
	public List<Note> getTrashed(String token) {
		//Long userId=webClientService.getUserId(token);
		 List<User> userId=webClientService.getUserId(token);
		 List<Note> trashedNotes=null;
		if(userId!=null) {
			
			trashedNotes=notesrepo.getAllTrashed(userId);
			
			//trashedNotes=notesrepo.getAllTrashed(userId);
		}
		return trashedNotes;
	
	
}
	@Override
	public boolean trashed(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
		//List<User> userId=webClientService.getUserId(token);
		//if(notesrepo.setTrashed(userId, noteId)) {
		if(notesrepo.setTrashed(userId, noteId)) 
			return true;
		}
		return false;
	}*/
	
	
}
	
	
	
	
	 
	 
	 
	 
	/*
	 * /*@Transactional
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
	*/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /* @Transactional
	@Override
	public List<Note> showAllNotes(String token) {
		
		List<Note> noteList = noteDAO.getAllNotes(token);
		if (noteList != null) {
			return noteList;
		}
		return null;
	}
    @Transactional
	@Override
	public List<Note> getArchieved(String token) {
		Long userId=webClientService.getUserId(token);
		List<Note> archievedNotes=null;
		if(userId!=null) {
			archievedNotes=noteDAO.getAllArchieved(userId);
		}
		return archievedNotes;
	}
    @Transactional
	@Override
	public List<Note> getTrashed(String token) {
		Long userId=webClientService.getUserId(token);
		List<Note> trashedNotes=null;
		if(userId!=null) {
			trashedNotes=noteDAO.getAllTrashed(userId);
		}
		return trashedNotes;
	}
    @Transactional
	@Override
	public List<Note> getPinned(String token) {
		Long userId=webClientService.getUserId(token);
		List<Note> pinnedNotes=null;
		if(userId!=null) {
			pinnedNotes=noteDAO.getAllPinned(userId);
		}
		return pinnedNotes;
	}
    @Transactional
	@Override
	public boolean trashed(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
		if(noteDAO.setTrashed(userId, noteId)) {
			return true;
		}
		return false;
	}
    @Transactional
	@Override
	public boolean restored(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
		if(noteDAO.setRestored(userId, noteId)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean pinned(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
		if(noteDAO.setPinned(userId, noteId)) {
			return true;
		}
		return false;
	}
	@Transactional
	@Override
	public boolean unPinned(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
		if(noteDAO.setUnpinned(userId, noteId)) {
			return true;
		}
		return false;
	}
	@Transactional
	@Override
	public boolean archieved(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
        if(noteDAO.setArchieved(userId, noteId)) {
        	return true;
        }
		return false;
	}
	@Transactional
	@Override
	public boolean unarchieved(String token, Long noteId) {
		Long userId=webClientService.getUserId(token);
        if(noteDAO.setUnachieved(userId, noteId)) {
        	return true;
        }
		return false;
	}
    @Transactional
	@Override
	public boolean remindMe(String token, Long noteId, LocalDateTime time) {
	    Long userId=webClientService.getUserId(token);
	    if(noteDAO.setRemaineder(userId, noteId, time)) {
	    	return true;
	    }
		return false;
	}
    @Transactional
	@Override
	public boolean setColor(String token, Long noteId, String color) {
    	Long userId=webClientService.getUserId(token);
		if(noteDAO.setColor(userId, noteId, color)) {
			return true;
		}
		return false;
	} 
    
    
	
}
	 * 
	 * 
	 * 
	 */ 


