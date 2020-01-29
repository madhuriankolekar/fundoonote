package com.bridgelabz.fundoonotes.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.fundoonotes.dto.Notesdto;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.Notesservice;
//import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Api(value = "fundoonote")
public class Notescontroller {
	@Autowired
	private Notesservice notesservice;
	
	@PostMapping("/notes/create/{token}")
	public ResponseEntity<Response> create(@Valid @RequestBody Notesdto noteDTO,@RequestHeader String token){
		notesservice.create(noteDTO,token);
		{
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(), " Successfully created"),HttpStatus.OK);
		}
	}
	@PostMapping("notes/update")
public ResponseEntity<Response> updateNote(@Valid @RequestBody Integer noteId,Note note) {
	if(notesservice.isUpdated(noteId, note))
	{
	return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "notes successfully create"),
			HttpStatus.OK);
	}
			return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), "notes not created"),
			HttpStatus.BAD_REQUEST);
}

@GetMapping("notes/getall")
public ResponseEntity<Response> getAllNotes(@PathVariable(value = "token") String token){
	
	List<Note> noteList=notesservice.showAllNotes(token);
	if(!noteList.isEmpty()) {
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "notes successfully create"),
				HttpStatus.OK);
		}
	return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), "notes not created"),
				HttpStatus.BAD_REQUEST);
	}
@PostMapping("/notes/trashed/{noteId}")
public ResponseEntity<Response> trashed(@RequestHeader String token,@PathVariable Long noteId){
	if(notesservice.trashed(token, noteId)) {
		return new ResponseEntity<> (new Response(HttpStatus.OK.value(),"Note is Trashed"),HttpStatus.OK);
	}
	return new ResponseEntity<> (new Response(HttpStatus.BAD_REQUEST.value(),"Note is not Trashed"),HttpStatus.BAD_REQUEST);
}
@GetMapping("/trashednotes")
public ResponseEntity<Response> getTrashedNotes(@RequestHeader String token){
	List<Note> trashedNotes=notesservice.getTrashed(token);
	if(trashedNotes.isEmpty()) {
		
	//return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"List of Trashed notes",trashedNotes),HttpStatus.OK);
	
		return new ResponseEntity<> (new Response(HttpStatus.OK.value(),"list of  Trashed note"),HttpStatus.OK);
	}
	return new ResponseEntity<> (new Response(HttpStatus.BAD_REQUEST.value()," not Trashed"),HttpStatus.BAD_REQUEST);

	
}
@GetMapping("/get")
public String get() {
	return "hello";
}
}


















































































