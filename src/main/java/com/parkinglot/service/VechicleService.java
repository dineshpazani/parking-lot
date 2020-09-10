package com.parkinglot.service;

import java.util.List;

import com.parkinglot.model.VehicleModel;

public interface VechicleService {
	
		
	List<VehicleModel> getParkedHistory();
	
	VehicleModel getVechilesById(String vechileId);

}
