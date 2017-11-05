package model;

import core.Marks;

public class MarksModel {
private Marks mark;
	
	public MarksModel(Marks mark){
		this.mark = mark;
	}
	
	public boolean insert() {
		return false;
	}

	public Marks update() {
		return mark;
	}

	public boolean delete() {
		
		return false;
	}

	public Marks search() {
		return mark;
	}
}
