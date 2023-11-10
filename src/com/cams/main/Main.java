package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manager.CampManager;
import model.CampInfo;
import model.Eligibility;
import model.Staff;

public class Main {

	public static void main(String args[]) throws ClassNotFoundException, IOException {
			
		CampManager campmanager = new CampManager();

		
		Date date1 = new Date(2023, 12, 1);
		Date date2 = new Date(2000, 12, 12);
		
		CampInfo camp1info = new CampInfo();
		camp1info.setName("camp 1");
		camp1info.setId(001);
		List <Date> datelist1 = new ArrayList<Date>();
		datelist1.add(date1);
		camp1info.setDates(datelist1);
		camp1info.setEligibility(Eligibility.SCHOOL);
		camp1info.setLocation("NTU");
		camp1info.setTotalSlots(10);
		camp1info.setCommitteeSlots(5);
		camp1info.setDescription("Outdoors Bootcamp.");
		
		Staff staff1 = new Staff();
		staff1.setUserId("staff1");
		staff1.setFaculty("faculty1");
		staff1.setPassword("password");
		
		camp1info.setStaffInCharge(staff1);
		camp1info.setDeadline(date1);
		
		CampInfo camp2info = new CampInfo();
		camp2info.setName("camp 2");
		camp2info.setId(002);
		List <Date> datelist2 = new ArrayList<Date>();
		datelist2.add(date2);
		camp2info.setDates(datelist2);
		camp2info.setEligibility(Eligibility.FACULTY);
		camp2info.setLocation("NUS");
		camp2info.setTotalSlots(100);
		camp2info.setCommitteeSlots(50);
		camp2info.setDescription("Indoors Camping.");
		
		Staff staff2 = new Staff();
		staff2.setUserId("staff2");
		staff2.setFaculty("faculty2");
		staff2.setPassword("password2");
		
		camp1info.setStaffInCharge(staff2);
		camp1info.setDeadline(date2);
		
		campmanager.createCamp(camp1info);
		campmanager.createCamp(camp2info);
		

		
		/*
		Context context = Context.createContext();
		
		while(true) launch(context);
		}
		
		private static void launch(Context context) {
			LoginPortal loginPortal = new LoginPortal(context);
			LoginSession session = loginPortal.openPortal();
			
			SessionManager sessionManager = new SessionManager(context, session);
			sessionManager.startSession();
		}
		*/
	}
}