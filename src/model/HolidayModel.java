package model;

import core.Holiday;

public class HolidayModel {

	private Holiday holiday;
	
	public HolidayModel(Holiday holiday){
		this.holiday = holiday;
	}
	
	public boolean insert() {
		return false;
	}

	public Holiday update() {
		return holiday;
	}

	public boolean delete() {
		
		return false;
	}

	public Holiday search() {
		return holiday;
	}
}
