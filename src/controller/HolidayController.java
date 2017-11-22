package controller;

import core.Holiday;
import model.HolidayModel;

public class HolidayController {

    private HolidayModel holidayModel;

    public HolidayController(Holiday workingDay) {
        this.holidayModel = new HolidayModel(workingDay);
    }

    public boolean insert() {
        return this.holidayModel.insert();
    }

    public Holiday update() {
        return this.holidayModel.update();
    }

    public Holiday search() {
        return this.holidayModel.search();
    }

    public boolean delete() {
        return this.holidayModel.delete();
    }

    public HolidayModel getDefaultModel() {
        return holidayModel;
    }

    public void setDefaultModel(HolidayModel holidayModel) {
        this.holidayModel = holidayModel;
    }
}
