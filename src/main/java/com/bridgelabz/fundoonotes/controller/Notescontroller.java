package com.bridgelabz.fundoonotes.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.fundoonotes.dto.Notesdto;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.Notesservice;

@RestController
public class Notescontroller {
	@Autowired
private  Notesservice notesservice;
	@PostMapping("/iscreate")
	public ResponseEntity<Response> iscreate(@Valid @RequestBody Notesdto notesDTO){
		
		if(notesservice.isCreated( notesDTO))
		{
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"notes successfully create"),HttpStatus.OK);
		}
		 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"notes not created"),HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/isupdated")
	 //updateNote(Integer noteId,Note note);
	public ResponseEntity<Response>     isUpdated(@Valid @RequestBody Integer id,Note notedto) {
		if(notesservice.isUpdated(id, notedto))//.isUpdated(noteId, note))///.isCreated( notesDTO))
				{
				return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"notes successfully updated"),HttpStatus.OK);
			}
			 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"notes not updated"),HttpStatus.BAD_REQUEST);
		}

	@PostMapping("/isdeleted")
	 //updateNote(Integer noteId,Note note);
	public ResponseEntity<Response>     isDeleted(@Valid @RequestBody Integer noteId) {
		if(notesservice.isDeleted(noteId))
				{
				return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"notes successfully deleted"),HttpStatus.OK);
			}
			 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"notes not deleted"),HttpStatus.BAD_REQUEST);
		}
}
