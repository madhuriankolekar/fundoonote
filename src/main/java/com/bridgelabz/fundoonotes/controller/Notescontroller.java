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
	private Notesservice notesservice;

	@PostMapping("notes/iscreate")
	public ResponseEntity<Response> iscreate(@Valid @RequestBody Notesdto notesDTO) {

		if (notesservice.isCreated(notesDTO)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "notes successfully create"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), "notes not created"),
				HttpStatus.BAD_REQUEST);
	}


@PostMapping("notes/update")
public ResponseEntity<Response> updateNote(@Valid @RequestBody Integer noteId,Note note) {
	if(notesservice.isUpdated(noteId, note))
	return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "notes successfully create"),
			HttpStatus.OK);;
			return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), "notes not created"),
			HttpStatus.BAD_REQUEST);
} 

}
