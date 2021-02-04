package com.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.model.BloodBankRegister;
import com.main.model.DonateBlood;
import com.main.model.Login;
import com.main.model.RequestBlood;
import com.main.service.UserService;

@Controller
public class BloodBankController {

	private static Logger log = Logger.getLogger(BloodBankController.class);
	@Autowired
	private UserService userService;

	// Welcoming Home Page
	@RequestMapping(value = "/BloodBankManagementPortal")
	public String welcomeBloodBank() {
		log.info("Welcome to Home Page");
		return "HomePage";
	}

	// Invoking Registration Page
	@RequestMapping(value = "/UserRegistration")
	public String UserRegister(ModelMap m) {
		log.info("Loading Registration Page");
		BloodBankRegister b = new BloodBankRegister();
		m.addAttribute("UserForm", b);
		return "UserRegistration";
	}

	// Saving Registration Details
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@Validated @ModelAttribute("UserForm") BloodBankRegister b, BindingResult result,
			ModelMap m) {
		log.info("Registering your details into the DataBase");
		String viewPage;
		if (result.hasErrors()) {
			viewPage = "UserRegistration";
		} else {

			userService.saveUser(b);
			viewPage = "HomePage";
		}
		return viewPage;
	}

	// Checking Available Blood/Donor
	@RequestMapping(value = "/CheckBloodAvailability", method = RequestMethod.GET)
	public String displayBloodAvailability(@Validated @ModelAttribute("UserForm") BloodBankRegister b,
			BindingResult result, ModelMap m) {
		log.info("Checking Blood/Donor availability by fetching details from the DataBase");
		List<BloodBankRegister> availablelist = userService.availableList();
		m.addAttribute("AvailableList", availablelist);
		return "DisplayDetails";
	}

	// Login for Requesting Blood
	@RequestMapping(value = "/RequestBloodAndCheckStatus")
	public String requestBloodLogin(ModelMap m) {
		log.info("Requestor login for requesting blood");
		Login l = new Login();
		m.addAttribute("loginForm", l);
		return "LoginForm";
	}

	// Form For Requesting Blood
	@RequestMapping(value = "/requestBlood", method = RequestMethod.POST)
	public String requestBlood(@Validated @ModelAttribute("loginForm") Login l, BindingResult result, ModelMap m) {
		log.info("Requestor Form Loading...");
		String viewPage;
		List<BloodBankRegister> rlist = userService.availableList();
		m.addAttribute("RList", rlist);
		RequestBlood rb = new RequestBlood();
		String name = userService.checkUser(l);
		if (name == "UserNotFound" || result.hasErrors()) {
			System.out.println("Fail");
			viewPage = "LoginForm";
		} else {
			m.addAttribute("requestForm", rb);
			m.addAttribute("username", name);
			viewPage = "RequestBlood";
		}
		return viewPage;
	}
	
	// Saving Request For Blood Details
	@RequestMapping(value = "/saveRequestBloodDetails", method = RequestMethod.POST)
	public String requestBloodSave(@Validated @ModelAttribute("requestForm") RequestBlood rb, BindingResult result,
			ModelMap m) {
		log.info("Saving Requestor Details in the Database");
		String view = "";
		if (result.hasErrors()) {
			view = "RequestBlood";
		} else {
			rb.setStatus("Pending");
			userService.saveRequestBloodDetails(rb);
			view = "HomePage";
		}
		return view;
	}
	

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest request){
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
            return "HomePage";
        }



	// Login For Donating Blood
	@RequestMapping(value = "/DonateBloodAndCheckStatus")
	public String DonateBloodLogin(ModelMap m) {
		log.info("Donor login for donating blood");
		Login l2 = new Login();
		m.addAttribute("donateLoginForm", l2);
		return "DonateLoginForm";
	}

	// Form For Donating Blood
	@RequestMapping(value = "/donateBlood", method = RequestMethod.POST)
	public String donateBlood(@Validated @ModelAttribute("donateLoginForm") Login l2, BindingResult result,
			ModelMap m) {
		log.info("Donor Form Loading...");
		String viewPage;
		DonateBlood db = new DonateBlood();
		String name = userService.checkUser(l2);
		if (name == "UserNotFound" || result.hasErrors()) {
			System.out.println("Fail");
			viewPage = "DonateLoginForm";
		} else {
			m.addAttribute("donateForm", db);
			m.addAttribute("username", name);
			viewPage = "DonateBlood";
		}
		return viewPage;
	}

	// Saving Donor Details
	@RequestMapping(value = "/saveDonateBloodDetails", method = RequestMethod.POST)
	public String donateBloodSave(@Validated @ModelAttribute("donateForm") DonateBlood db, BindingResult result,
			ModelMap m) {
		String view = "";
		if (result.hasErrors()) {
			view = "DonateBlood";
		} else {
			log.info("Saving Donor Details in the DataBase");
			db.setStatus("Pending");
			userService.saveDonateBloodDetails(db);
			view = "HomePage";
		}
		return view;
	}

	// Admin login Form
	@RequestMapping(value = "/Admin")
	public String adminLogin(ModelMap m) {
		log.info("Admin Login Page Loading...");
		Login l3 = new Login();
		m.addAttribute("adminLoginForm", l3);
		return "AdminLoginForm";
	}

	// Authenticating Admin Login
	@RequestMapping(value = "/checkAdminLogin", method = RequestMethod.POST)
	public String checkAdminLogin(@Validated @ModelAttribute("adminLoginForm") Login l3, BindingResult result,
			ModelMap m) {
		log.info("Authenticating Admin Credentials");
		String viewPage = "";
		if (l3.getUsername().equals("admin") && l3.getPassword().equals("admin")) {
			List<DonateBlood> dlist = userService.donorList();
			List<RequestBlood> rlist = userService.requestorList();
			m.addAttribute("DList", dlist);
			m.addAttribute("RList", rlist);
			viewPage = "AdminTable";
		} else if (result.hasErrors()) {
			viewPage = "AdminLoginForm";
		} else {
			viewPage = "AdminLoginForm";
		}
		return viewPage;
	}

	// Admin Accepting Request Of Blood
	@RequestMapping(value = "/AcceptStatus/{id}")
	public String AcceptStatus(@PathVariable("id") Integer rid, ModelMap m) {
		log.info("Admin accepting Requestor's Request");
		userService.acceptStatus(rid);
		List<DonateBlood> dlist = userService.donorList();
		List<RequestBlood> rlist = userService.requestorList();
		m.addAttribute("DList", dlist);
		m.addAttribute("RList", rlist);
		return "AdminTable";
	}

	// Admin Rejecting Request Of Blood
	@RequestMapping(value = "/RejectStatus/{id}")
	public String RejectStatus(@PathVariable("id") Integer rid, ModelMap m) {
		log.info("Admin Rejecting Requestor's Request");
		userService.rejectStatus(rid);
		List<DonateBlood> dlist = userService.donorList();
		List<RequestBlood> rlist = userService.requestorList();
		m.addAttribute("DList", dlist);
		m.addAttribute("RList", rlist);
		return "AdminTable";
	}

	// Admin accepting Donation of Blood
	@RequestMapping(value = "/DonorAcceptStatus/{id}")
	public String DonorAcceptStatus(@PathVariable("id") Integer did, ModelMap m) {
		log.info("Admin accepting Donor");
		userService.donorAcceptStatus(did);
		List<DonateBlood> dlist = userService.donorList();
		List<RequestBlood> rlist = userService.requestorList();
		m.addAttribute("DList", dlist);
		m.addAttribute("RList", rlist);
		return "AdminTable";
	}

	// Admin Rejecting Donor Blood
	@RequestMapping(value = "/DonorRejectStatus/{id}")
	public String DonorRejectStatus(@PathVariable("id") Integer did, ModelMap m) {
		log.info("Admin Rejecting the Donor");
		userService.donorRejectStatus(did);
		List<DonateBlood> dlist = userService.donorList();
		List<RequestBlood> rlist = userService.requestorList();
		m.addAttribute("DList", dlist);
		m.addAttribute("RList", rlist);
		return "AdminTable";
	}

	// Requestor login for Checking his/her status
	@RequestMapping(value = "/RCheckStatus")
	public String rCheckLogin(ModelMap m) {
		log.info("Requestor Login for checking his/her status");
		Login l4 = new Login();
		m.addAttribute("checkRequestloginForm", l4);
		return "CheckRequestLogin";
	}

	// Donor login for Checking his/her status
	@RequestMapping(value = "/DCheckStatus")
	public String dCheckLogin(ModelMap m) {
		log.info("Donor Login for checking his/her status");
		Login l5 = new Login();
		m.addAttribute("checkDonorloginForm", l5);
		return "CheckDonorLogin";
	}

	// Requestor checking his/her status
	@RequestMapping(value = "/cRQ")
	public String rCheckStatus(@ModelAttribute("checkRequestloginForm") Login l, ModelMap m) {
		log.info("Requestor Status Loading...");
		String status = userService.rCheckStatus(l.getUsername());
		// System.out.println(status);
		m.addAttribute("username", l.getUsername());
		m.addAttribute("Status", status);
		return "RequestorStatus";
	}

	// Donor Checking his/her status
	@RequestMapping(value = "/cDQ")
	public String dCheckStatus(@ModelAttribute("checkDonorloginForm") Login l, ModelMap m) {
		log.info("Donor Status Loading...");
		String status = userService.dCheckStatus(l.getUsername());
		// System.out.println(status);
		m.addAttribute("username", l.getUsername());
		m.addAttribute("Status", status);
		return "DonorStatus";
	}

}
