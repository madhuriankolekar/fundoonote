package com.bridgelabz.fundoonotes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.Labeldto;
import com.bridgelabz.fundoonotes.model.Label;

import com.bridgelabz.fundoonotes.repo.Labelrepo;
@Service
public class Labelserviceimpl implements Labelservice{
	@Autowired
	private Labelrepo labelrepo;
	@Transactional
	@Override
	public boolean isCreated(Labeldto labelDTO) {
		Label label=labelDTOTolabel(labelDTO);
		Label labelObj= labelrepo.create(label);
		if(labelObj!=null) {
		return true;	
		}
		return false;
	}

	private Label labelDTOTolabel(Labeldto label) {
		Label labels = new Label();
		labels.setLname(label.getLname());
		labels.setSname(label.getSname());
		labels.setMobileno(label.getMobileno());
		return labels;
		
		
		
	}

	
	@Override
	public boolean isDeleted(Integer labelId) {
		Label label=labelrepo.delete(labelId);
		if(label!=null) {
		return true;
	}
		return false;
	}

	@Override
	public boolean isUpadated(Integer labelId, Labeldto labelDTO) {
		Label labelObj=labelDTOTolabel(labelDTO);
		Label label=labelrepo.update(labelId, labelObj);
		if(label!=null) {
		return true;
	}
		return false;

	
	
	}
}

