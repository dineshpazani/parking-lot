package com.parkinglot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.model.ParkingMetaModel;
import com.parkinglot.model.ParkingModel;
import com.parkinglot.model.VehicleModel;
import com.parkinglot.service.ParkingService;

@RestController
@RequestMapping("/v1/parkingservice")
public class ParkingLotController {
	
	@Autowired
	private ParkingService parkingService;
	
	@GetMapping(value = "/getalldetails")
	public Map<Integer, ParkingModel> getalldetails() {		
		return parkingService.getparkedVachilesList();
	}
	
	@PostMapping(value = "/addparkingmetainfo", consumes = "application/json", produces = "application/json")
	public ParkingMetaModel addParkingMetaInfo(@RequestBody ParkingMetaModel parkingMetaModel) {		
		return parkingService.addParkingMetaInfo(parkingMetaModel);
	}
	
	@PostMapping(value = "/vechilein", consumes = "application/json")
	public String vechilein(@RequestBody ParkingModel parkingModel) {		
		return parkingService.parkingIn(parkingModel);
	}
	
	@PostMapping(value = "/vechileout/{vechileNo}", produces = "application/json")
	public VehicleModel vechileOut(@PathVariable("vechileNo")String vechileNo) {		
		return parkingService.parkingOut(vechileNo);
	}
	
	
	@GetMapping(value = "/freeslots")
	public List<Integer> getfreesltos() {		
		return parkingService.getAvailableParkingSlots();
	}
	
}
