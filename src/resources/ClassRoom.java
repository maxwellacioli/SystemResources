package resources;

import java.util.Date;

import users.User;

public class ClassRoom extends Resource {
	
	private static String TYPE = "Sala de Aula";

	public ClassRoom(int id, Date beginDate, Date endDate, User userResponsable) {
		super(id, beginDate, endDate, userResponsable);
		setTypeName(TYPE);
	}

	public ClassRoom(int id) {
		super(id);
		setTypeName(TYPE);
	}

}
