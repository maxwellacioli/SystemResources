package resources;

import java.util.Date;

import users.User;

public class Auditorium extends Resource {

	private static String TYPE = "Auditório";

	public Auditorium(int id, Date beginDate, Date endDate, User userResponsable) {
		super(id, beginDate, endDate, userResponsable);
		setTypeName(TYPE);
	}

	public Auditorium(int id) {
		super(id);
		setTypeName(TYPE);
	}

}
