package main;

public class Report {
	private int totalUsers;
	private int totalResourceAllocation;
	private int totalResourceAllocated;
	private int totalResourceInProgress;
	private int totalResourceCompleted;
	private int totalRAllocated;
	private int totalClassActivitie;
	private int totalApresentationActivitie;
	private int totalLabActivitie;

	public Report() {
		totalUsers = totalResourceInProgress = totalResourceCompleted = totalResourceAllocation = totalResourceAllocated = totalRAllocated = totalLabActivitie = totalClassActivitie = totalApresentationActivitie = 0;
	}

	public void updateTotalUser() {
		totalUsers++;
	}

	public void updateTotalResourceAllocation() {
		totalResourceAllocation++;
	}

	public void updateTotalResourceAllocated() {
		totalResourceAllocated++;
	}

	public void updateTotalResourceInProgress() {
		totalResourceInProgress++;
	}

	public void updateTotalResourceCompleted() {
		totalResourceCompleted++;
	}

	public void updateTotalRAllocated() {
		totalRAllocated++;
	}

	public void updateTotalClassActivitie() {
		totalClassActivitie++;
	}

	public void updateTotalApresentationActivitie() {
		totalApresentationActivitie++;
	}

	public void updateTotalLabActivitie() {
		totalLabActivitie++;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public int getTotalResourceAllocation() {
		return totalResourceAllocation;
	}

	public int getTotalResourceAllocated() {
		return totalResourceAllocated;
	}

	public int getTotalResourceInProgress() {
		return totalResourceInProgress;
	}

	public int getTotalResourceCompleted() {
		return totalResourceCompleted;
	}

	public int getTotalRAllocated() {
		return totalRAllocated;
	}

	public int getTotalClassActivitie() {
		return totalClassActivitie;
	}

	public int getTotalApresentationActivitie() {
		return totalApresentationActivitie;
	}

	public int getTotalLabActivitie() {
		return totalLabActivitie;
	}

}
