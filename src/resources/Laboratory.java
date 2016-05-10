package resources;

import java.util.Date;

import users.User;

public class Laboratory extends Resource{
	
	private static String TYPE = "Laboratório";

	public Laboratory(int id, Date beginDate, Date endDate, User userResponsable) {
		super(id, beginDate, endDate, userResponsable);
		setTypeName(TYPE);
	}
	
	public Laboratory(int id) {
		super(id);
		setTypeName(TYPE);
	}
}
