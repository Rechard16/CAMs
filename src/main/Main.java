package main;

import java.io.IOException;
import java.util.Date;

import boundary.PermissionManager;
import boundary.SessionManager;
import boundary.login.LoginPortal;
import boundary.login.LoginSession;
import manager.CampManager;
import manager.SuggestionManager;
import manager.UserManager;

public class Main {

	public static void main(String args[]) throws ClassNotFoundException, IOException {
		// new ImportFile().importFile();
		CampManager campmanager = new CampManager();
		SuggestionManager sm = new SuggestionManager();
		
		Date date1 = new Date(2023, 12, 1);
		Date date2 = new Date(2000, 12, 12);
		
		/*Suggestion sg = new Suggestion(null, 0, null, sm);
		sg.setCampID(0);
		sg.setDescription("hi");
		sg.setSuggestionID(12);
		sg.setUser(99, "df", "sdf","sdf");
		sm.addSuggestion(null, sg, null);
		*/

		/*
		CampInfo camp1info = new CampInfo();
		camp1info.setName("camp 1");
		camp1info.setID(001);
		List <Date> datelist1 = new ArrayList<Date>();
		datelist1.add(date1);
		camp1info.setDates(datelist1);
		camp1info.setEligibility(Faculty.SCHOOL);
		camp1info.setLocation("NTU");
		camp1info.setTotalSlots(10);
		camp1info.setCommitteeSlots(5);
		camp1info.setDescription("Outdoors Bootcamp.");
		camp1info.setDeadline(new Date());
		
		CampInfo camp2info = new CampInfo();
		camp2info.setName("camp 2");
		camp2info.setID(002);
		List <Date> datelist2 = new ArrayList<Date>();
		datelist2.add(date2);
		camp2info.setDates(datelist2);
		camp2info.setEligibility(Faculty.SCSE);
		camp2info.setLocation("NUS");
		camp2info.setTotalSlots(100);
		camp2info.setCommitteeSlots(50);
		camp2info.setDescription("Indoors Camping.");
		camp2info.setDeadline(new Date());
		
		campmanager.createCamp(camp1info);
		campmanager.createCamp(camp2info);

		System.out.println(campmanager.getAllCamps().size());
		*/
		

		
		Context context = Context.createContext(new UserManager(), new PermissionManager(), campmanager);
		
		while(launch(context));
		context.print("Ending program. Thank you for using CAMs!");
	}
		
	private static boolean launch(Context context) {
		LoginPortal loginPortal = new LoginPortal(context);
		LoginSession session = loginPortal.openPortal();
		if (session == null) return false;
		
		SessionManager sessionManager = new SessionManager(context, session);
		sessionManager.startSession();
		return true;
	}
}