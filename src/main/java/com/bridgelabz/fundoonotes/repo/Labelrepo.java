package com.bridgelabz.fundoonotes.repo;

import com.bridgelabz.fundoonotes.model.Label;

public interface Labelrepo {

    Label create(Label label);
	
	Label delete(Integer labelId);
	
	Label update(Integer labelId,Label label);

	//Note createNote(Note note);

}
