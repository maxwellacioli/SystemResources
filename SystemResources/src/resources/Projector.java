package resources;

import java.util.Date;

import users.User;

public class Projector extends Resource {
	
	private static String TYPE = "Projetor";

	public Projector(int id, Date beginDate, Date endDate, User userResponsable) {
		super(id, beginDate, endDate, userResponsable);
		setTypeName(TYPE);
	}
	
	public Projector(int id) {
		super(id);
		setTypeName(TYPE);
	}

}
