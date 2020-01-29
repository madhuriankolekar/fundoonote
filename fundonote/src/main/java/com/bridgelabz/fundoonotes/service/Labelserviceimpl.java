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
String la=labelDTO.getLabelname();
//String token=jwtprovider.generateToken(email);
//tring url="http://localhost:8080/users/varified/";
//jmsprovider.sendEmail(email, token, url);
return true;	
}
return false;
}
@Transactional
private Label labelDTOTolabel(Labeldto labelss) {
Label labels = new Label();
//labels.setLabelId(labelss.g);//setLabelid(labelss.getLabelid());
labels.setLabelname(labelss.getLabelname());
return labels;
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
@Transactional
@Override
public boolean isDeleted(Integer labelId) {
Label label=labelrepo.delete(labelId);
if(label!=null) {
return true;
}
return false;
	}
}

