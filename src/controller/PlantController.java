package controller;

import model.PlantModel;

public class PlantController {
	private PlantModel plantModel;
	
	public void modifyPlantNumber(int numeroPlanta) {
		plantModel.modifyPlantNumber(numeroPlanta);
	}
}
