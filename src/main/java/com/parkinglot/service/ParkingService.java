package com.parkinglot.service;

import java.util.List;
import java.util.Map;

import com.parkinglot.model.ParkingMetaModel;
import com.parkinglot.model.ParkingModel;
import com.parkinglot.model.VehicleModel;

public interface ParkingService {
	
	ParkingMetaModel addParkingMetaInfo(ParkingMetaModel parkingMetaModel);
	
	String parkingIn(ParkingModel parkingModel);
	
	VehicleModel parkingOut(String vechileNo);
	
	Map<Integer, ParkingModel> getparkedVachilesList();
	
	List<Integer> getAvailableParkingSlots();

}
