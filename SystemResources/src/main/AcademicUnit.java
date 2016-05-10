package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import users.*;
import activities.*;
import resources.*;

public class AcademicUnit {
	private ArrayList<Resource> resourcesList;
	private ArrayList<User> usersList;
	public Report report;

	public AcademicUnit() {
		this.resourcesList = new ArrayList<Resource>();
		this.usersList = new ArrayList<User>();
		report = new Report();
	}

	public void addResource(Resource rsc) {
		resourcesList.add(rsc);
		// TODO verificar instancias do relatorio e incrementar
		// if(rsc instanceof Auditorium) {
		// }
	}

	public void addUser(User usr) {
		usersList.add(usr);
		// TODO verificar instancias do usuario e incrementar
	}

	public User userConsult(int id) {
		for (User u : usersList) {
			if (u.getUserID() == id) {
				return u;
			}
		}
		return null;
	}

	public Resource resourceConsult(int id) {
		for (Resource r : resourcesList) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}

	public void updateResourse(int id, int beginYear, int beginMonth,
			int beginDate, int beginHrs, int beginMin, int endYear,
			int endMonth, int endDate, int endHrs, int endMin,
			User responsable, Activitie act, String status) throws Exception {

		Resource rsc = resourceConsult(id);

		if (rsc == null) {
			throw new Exception();
		}

		rsc = new Resource(id);

		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.set(beginYear, beginMonth, beginDate, beginHrs, beginMin);
		rsc.setBeginDate(beginCalendar.getTime());

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.set(endYear, endMonth, endDate, endHrs, endMin);
		rsc.setEndDate(endCalendar.getTime());

		rsc.setUserResponsable(responsable);
		rsc.setActivitie(act);
		rsc.setStatusAllocation(status);
		rsc.setTypeName(resourceConsult(id).getTypeName());
		rsc.addActivitie(act);

		resourcesList.remove(resourceConsult(id));
		resourcesList.add(rsc);
	}

	// public void requestResource(User usr, Resource rsc, Activitie act) {
	//
	// }
}
