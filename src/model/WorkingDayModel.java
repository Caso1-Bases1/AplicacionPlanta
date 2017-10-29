package model;

import core.WorkingDay;

public class WorkingDayModel {

	private WorkingDay workinDay;
	
	public WorkingDayModel(WorkingDay workinDay) {
		this.workinDay = workinDay;
	}

	public boolean insert() {
		
		return false;
	}

	public WorkingDay update() {		
		return workinDay;
	}

	public boolean delete() {
		
		return false;
	}

	public WorkingDay search() {
		return workinDay;
	}

}
