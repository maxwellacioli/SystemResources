package users;

import java.util.ArrayList;
import activities.Activitie;
import resources.Resource;

public class User {
	
	public static final String STD_GRAD = "Aluno Graduação";
	public static final String STD_MES = "Aluno Mestrado";
	public static final String STD_DOC = "Aluno Doutorado";
	public static final String USR_ADM = "Administrador";
	public static final String USR_RES = "Pesquisador";
	
	private int userID;
	private String userName;
	private String userEmail;
	private String userType;
	private ArrayList<Resource> resourcesAllocated;
	private ArrayList<Activitie> activitiesParticipantes;
	private boolean status;

	public User(int userID, String userName, String userEmail, String userType) {
		resourcesAllocated = new ArrayList<Resource>();
		activitiesParticipantes = new ArrayList<Activitie>();
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userType = userType;
		this.status = true;
	}

	public void addResource(Resource rsc) {
		resourcesAllocated.add(rsc);
	}
	
	public ArrayList<Resource> getResourcesAllocated() {
		return resourcesAllocated;
	}

	public void addActivitie(Activitie act) {
		activitiesParticipantes.add(act);
	}
	
	public ArrayList<Activitie> getActivitiesParticipantes() {
		return activitiesParticipantes;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getEmail() {
		return userEmail;
	}

	public void setEmail(String email) {
		this.userEmail = email;
	}

	public void changeStatus() {
		this.status = !this.status;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
