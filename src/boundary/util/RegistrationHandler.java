package boundary.util;

import java.util.Date;

import exception.NoSlotException;
import exception.RegistrationPeriodExpiredException;
import exception.TimePeriodClashException;
import main.Context;
import model.Camp;
import model.CampInfo;
import model.Student;
import model.User;

public class RegistrationHandler {
	private final Context context;
	private final Student student;
	private final Camp camp;
	private final boolean committee;
	
	public RegistrationHandler(Context context, User user, Camp camp, boolean committee) {
		this.context = context;
		this.student = (Student) user;
		this.camp = camp;
		this.committee = committee;
	}
	
	public boolean register() throws Exception {
		this.check();
		student.register(camp);
		camp.addStudent(student.getID());

		if (committee) {
			student.setCampID(camp.getID());
			camp.addCommitteeMember(student.getID());
		}
		
		context.getUserManager().save();
		context.getCampManager().save();
		return true;
	}
	

	private void check() throws Exception {
		
		CampInfo info = camp.getInformation();
		
		if (info.getTotalSlots() == camp.getTotalRegistered())
			throw new NoSlotException();
		
		if (committee && info.getCommitteeSlots() == camp.getCommitteeMembers().size())
			throw new NoSlotException();
		
		Date now = new Date();
		if (now.after(info.getDeadline()))
			throw new RegistrationPeriodExpiredException();
		
		DateChecker checker = new DateChecker(camp);
		
		for (int campID: student.getCamps()) {
			Camp other = context.getCampManager().getCampByID(campID);
			
			if (!checker.checkViable(other)) 
				throw new TimePeriodClashException(other.getInformation().getName());
		}
	}
}
