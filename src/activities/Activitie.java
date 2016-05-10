package activities;

import java.util.ArrayList;
import users.User;

public class Activitie {
	private String tittle;
	private String description;
	private ArrayList<User> participants;
	private ArrayList<SupportMaterial> supportMaterials;

	public Activitie(String tittle, String description) {
		this.tittle = tittle;
		this.description = description;
		participants = new ArrayList<User>();
		supportMaterials = new ArrayList<SupportMaterial>();
	}

	public void addParticipant(User usr) {
		participants.add(usr);
	}

	public void addSupportMaterial(SupportMaterial sm) {
		supportMaterials.add(sm);
	}
	
	public ArrayList<User> getParcipantsList() {
		return participants;
	}
	
	public ArrayList<SupportMaterial> getSupportMaterial() {
		return supportMaterials;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
