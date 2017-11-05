package controller;

import model.PlantModel;

public class PlantController {
	private PlantModel plantModel;
	
	public PlantController(){
		plantModel = new PlantModel();
	}
	
	public void modifyPlantNumber(int numeroPlanta) {
		plantModel.modifyPlantNumber(numeroPlanta);
	}
	
	public int getPlantNumber(){
		return plantModel.getPlantNumber();
	}
}
