package resources;

import java.util.ArrayList;
import java.util.Date;

import activities.Activitie;
import users.User;

public class Resource {
	public static final String DISPONIBLE = "Disponivel";
	public static final String ALLOCATED = "Alocado";
	public static final String PROGRESS = "Em andamento";
	public static final String ALLOCATION = "Em processo de alocação";
	public static final String COMPLETED = "Concluído";

	private int id;
	private Date beginDate;
	private Date endDate;
	private User userResponsable;
	private Activitie activitie;
	private String statusAllocation;
	private String typeName;
	private ArrayList<Activitie> activitiesHistorical;

	public Resource(int id, Date beginDate, Date endDate, User userResponsable) {
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.userResponsable = userResponsable;
		this.activitie = null;
		this.typeName = null;
		this.statusAllocation = DISPONIBLE;
		this.activitiesHistorical = new ArrayList<Activitie>();
	}

	public Resource(int id) {
		this.id = id;
		this.beginDate = null;
		this.endDate = null;
		this.userResponsable = null;
		this.activitie = null;
		this.typeName = null;
		this.activitiesHistorical = new ArrayList<Activitie>();
		this.statusAllocation = DISPONIBLE;
	}

	public void addActivitie(Activitie act) {
		activitiesHistorical.add(act);
	}

	public ArrayList<Activitie> getActivitiesHistorical() {
		return activitiesHistorical;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getUserResponsable() {
		return userResponsable;
	}

	public void setUserResponsable(User userResponsable) {
		this.userResponsable = userResponsable;
	}

	public String getStatusAllocation() {
		return statusAllocation;
	}

	public void setStatusAllocation(String statusAllocation) {
		this.statusAllocation = statusAllocation;
	}

	public Activitie getActivitie() {
		return activitie;
	}

	public void setActivitie(Activitie activitie) {
		this.activitie = activitie;
	}
}
