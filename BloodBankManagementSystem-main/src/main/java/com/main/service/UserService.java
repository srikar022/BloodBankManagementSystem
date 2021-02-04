package com.main.service;

import java.util.List;

import com.main.model.BloodBankRegister;
import com.main.model.DonateBlood;
import com.main.model.Login;
import com.main.model.RequestBlood;

public interface UserService {

	public void saveUser(BloodBankRegister b);

	public List<BloodBankRegister> availableList();

	public String checkUser(Login l2);

	public void saveRequestBloodDetails(RequestBlood rb);

	public void saveDonateBloodDetails(DonateBlood db);

	public List<DonateBlood> donorList();

	public List<RequestBlood> requestorList();

	public void acceptStatus(Integer rid);

	public void rejectStatus(Integer rid);

	public void donorAcceptStatus(Integer did);

	public void donorRejectStatus(Integer did);

	public String rCheckStatus(String username);

	public String dCheckStatus(String username);

}
