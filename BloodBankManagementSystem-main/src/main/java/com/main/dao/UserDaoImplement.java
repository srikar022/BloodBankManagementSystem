package com.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.BloodBankRegister;
import com.main.model.DonateBlood;
import com.main.model.Login;
import com.main.model.RequestBlood;

@Repository
public class UserDaoImplement implements UserDao {
	private static Logger log = Logger.getLogger(UserDaoImplement.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(BloodBankRegister b) {
		// TODO Auto-generated method stub
		log.info("Saving User details in the Database");
		sessionFactory.getCurrentSession().save(b);
	}

	public List<BloodBankRegister> availableList() {
		// TODO Auto-generated method stub
		log.info("Fetching Users List from the Database");
		Query q = sessionFactory.getCurrentSession().createQuery("from BloodBankRegister u");
		List<BloodBankRegister> availablelist = q.list();

		return availablelist;
	}

	@Override
	public String checkUser(Login l) {
		// TODO Auto-generated method stub
		log.info("Authenticating User");
		String uname = "";
		Query q = sessionFactory.getCurrentSession()
				.createQuery("select b from BloodBankRegister b where b.username=:x and b.password=:y");
		q.setParameter("x", l.getUsername());
		q.setParameter("y", l.getPassword());
		List list = q.list();
		if ((list != null) && (list.size() > 0)) {
			uname = l.getUsername();
		} else {
			uname = "UserNotFound";
		}
		return uname;
	}

	@Override
	public void saveRequestBloodDetails(RequestBlood rb) {
		// TODO Auto-generated method stub
		log.info("Saving Requestor Details in the DataBase");
		sessionFactory.getCurrentSession().save(rb);
	}

	@Override
	public void saveDonateBloodDetails(DonateBlood db) {
		// TODO Auto-generated method stub
		log.info("Saving Donor Details in the DataBase");
		sessionFactory.getCurrentSession().save(db);
	}

	@Override
	public List<DonateBlood> donorList() {
		// TODO Auto-generated method stub
		log.info("Fetching Donor Details from the DataBase");
		Query q = sessionFactory.getCurrentSession().createQuery("from DonateBlood d");
		List<DonateBlood> dlist = q.list();
		return dlist;
	}

	@Override
	public List<RequestBlood> requestorList() {
		// TODO Auto-generated method stub
		log.info("Fetching Requestor Details from the DataBase");
		Query q = sessionFactory.getCurrentSession().createQuery("from RequestBlood r");
		List<RequestBlood> rlist = q.list();
		return rlist;
	}

	@Override
	public void acceptStatus(Integer rid) {
		// TODO Auto-generated method stub
		log.info("Admin Accepting Requestor");
		Query q = sessionFactory.getCurrentSession().createQuery("update RequestBlood r set r.status=:a where r.id=:b");
		q.setParameter("a", "Accept");
		q.setParameter("b", rid);
		q.executeUpdate();
	}

	@Override
	public void rejectStatus(Integer rid) {
		// TODO Auto-generated method stub
		log.info("Admin Rejecting Requestor");
		Query q = sessionFactory.getCurrentSession().createQuery("update RequestBlood r set r.status=:a where r.id=:b");
		q.setParameter("a", "Reject");
		q.setParameter("b", rid);
		q.executeUpdate();
	}

	@Override
	public void donorAccepStatus(Integer did) {
		// TODO Auto-generated method stub
		log.info("Admin Accepting Donor");
		Query q = sessionFactory.getCurrentSession()
				.createQuery("update DonateBlood d set d.status=:a where d.patient_id=:b");
		q.setParameter("a", "Accept");
		q.setParameter("b", did);
		q.executeUpdate();
	}

	@Override
	public void donorRejectStatus(Integer did) {
		// TODO Auto-generated method stub
		log.info("Admin Rejecting Donor");
		Query q = sessionFactory.getCurrentSession()
				.createQuery("update DonateBlood d set d.status=:a where d.patient_id=:b");
		q.setParameter("a", "Reject");
		q.setParameter("b", did);
		q.executeUpdate();

	}

	@Override
	public String rCheckStatus(String username) {
		// TODO Auto-generated method stub
		log.info("Requestor Checking his/her Status");
		Query q = sessionFactory.getCurrentSession()
				.createQuery("select r.status from RequestBlood r where r.username=:x");
		q.setParameter("x", username);
		String st = (String) q.uniqueResult();
		System.out.println(st);
		return st;
	}

	@Override
	public String dCheckStatus(String username) {
		// TODO Auto-generated method stub
		log.info("Donor Checking his/her Status");
		Query q = sessionFactory.getCurrentSession()
				.createQuery("select d.status from DonateBlood d where d.username=:x");
		q.setParameter("x", username);
		String st = (String) q.uniqueResult();
		System.out.println(st);
		return st;
	}

}
