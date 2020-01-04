package com.bridgelabz.fundoonotes.service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.fundoonotes.dto.Labeldto;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.repo.Labelrepo;
import com.bridgelabz.fundoonotes.utility.JmsProvider;
import com.bridgelabz.fundoonotes.utility.JwtProvider;
@Service
public class Labelserviceimpl implements Labelservice{
	@Autowired
	private Labelrepo labelrepo;
	@Autowired
	private JmsProvider jmsprovider;
	@Autowired
	private JwtProvider jwtprovider;
	@Transactional
	@Override
	public boolean isCreated(Labeldto labelDTO) {
		Label label=labelDTOTolabel(labelDTO);
		Label labelObj= labelrepo.create(label);
		if(labelObj!=null) {
			String email=labelDTO.getEmail();
			String token=jwtprovider.generateToken(email);
			String url="http://localhost:8080/users/varified/";
			//jmsprovider.sendEmail(email, token, url);
		return true;	
		}
		return false;
	}
	
	@Transactional
	private Label labelDTOTolabel(Labeldto labelss) {
		Label labels = new Label();
		labels.setLname(labelss.getLname());
		labels.setSname(labelss.getSname());
		labels.setMobileno(labelss.getMobileno());
		labels.setEmail(labelss.getEmail());
		labels.setPassword(labelss.getPassword());
		return labels;
		}
@Transactional
	@Override
	public boolean isDeleted(Integer labelId) {
		Label label=labelrepo.delete(labelId);
		if(label!=null) {
		return true;
	}
		return false;
	}
	@Transactional
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

