package controller;

import core.WorkingDay;
import model.WorkingDayModel;

public class WorkingDayController {
	private WorkingDayModel workingDayModel;

	public WorkingDayController(WorkingDay workingDay) {
		this.workingDayModel = new WorkingDayModel(workingDay);
	}
	
	public boolean insert(){
		return this.workingDayModel.insert();
	}
	
	public WorkingDay update(){
		return this.workingDayModel.update();
	}
	
	public WorkingDay search(){
		return this.workingDayModel.search();
	}
	
	public boolean delete(){
		return this.workingDayModel.delete();
	}

	public WorkingDayModel getDefaultModel() {
		return workingDayModel;
	}

	public void setDefaultModel(WorkingDayModel workingDayModel) {
		this.workingDayModel = workingDayModel;
	}
}
