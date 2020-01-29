package com.bridgelabz.fundoonotes.repo;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.fundoonotes.model.Label;
@Repository
public class Labelrepoimpl  implements Labelrepo {
	@Autowired
	private EntityManager entityManager;
	@Transactional
	@Override
	 public Label create(Label label) {
		Session currentSession=entityManager.unwrap(Session.class);
		int status=0;
		status=(int) currentSession.save(label);
		if(status!=0) {
			System.out.println("jj");
			return label;
		}
		return null;
	}
	/*@Transactional
	public Label save(Label label)
	{int status = 0;
	Session session = entityManager.unwrap(Session.class);
	status = (int) session.save(label);
	if (status != 0)
	{
	return label;
	}
	return null;
	}*/
	
	@Transactional
	@Override
	public Label delete(Integer labelId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Label label=currentSession.get(Label.class, labelId);
		if(label!=null) {
			currentSession.delete(label);
			return label;
		}
		
		return null;
	}
	@Transactional
	@Override
	public Label update(Integer labelId, Label labelObj) {
		Session currentSession=entityManager.unwrap(Session.class);
		Label labelObj1=currentSession.get(Label.class, labelId);
		if(labelObj1!=null) {
			currentSession.update(labelObj1);
			
		return labelObj1;
		}
		return null;
	}
	
	

	
	
	}

