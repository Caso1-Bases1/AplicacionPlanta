package controller;

import core.Marks;
import model.MarksModel;

public class MarkController {
	private MarksModel marksModel;

	public MarkController(Marks mark) {
		this.marksModel = new MarksModel(mark);
	}
	
	public int insert(){
		return this.marksModel.insert();
	}
	
	public Marks update(){
		return this.marksModel.update();
	}
	
	public Marks search(){
		return this.marksModel.search();
	}
	
	public boolean delete(){
		return this.marksModel.delete();
	}

	public MarksModel getDefaultModel() {
		return marksModel;
	}

	public void setDefaultModel(MarksModel holidayModel) {
		this.marksModel = holidayModel;
	}
}
