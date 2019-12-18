package com.bridgelabz.fundoonotes.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.fundoonotes.dto.Labeldto;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.Labelservice;

@RestController
public class Labelcontroller {
	@Autowired
private  Labelservice labelservice;
	@PostMapping("/create")
	public ResponseEntity<Response> isCreated(@Valid @RequestBody Labeldto labelDTO){
		
		if(labelservice.isCreated(labelDTO)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Label successfully create"),HttpStatus.OK);
		}
		 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not created"),HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/isdeleted")
	public ResponseEntity<Response>  isDeleted(Integer labelId) {
		if(labelservice.isDeleted(labelId)){
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Label successfully create"),HttpStatus.OK);
		}
		 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not created"),HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/isupdated")
	public ResponseEntity<Response>  isUpadated(Integer labelId,Labeldto labelDTO) {
		if(labelservice.isUpadated(labelId, labelDTO)){
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Label successfully create"),HttpStatus.OK);
		}
		 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not created"),HttpStatus.BAD_REQUEST);
	}
		
}	
