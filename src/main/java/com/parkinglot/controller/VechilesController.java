package com.parkinglot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.model.VehicleModel;
import com.parkinglot.service.VechicleService;

@RestController
@RequestMapping("/v1/vechileservice")
public class VechilesController {
	
	@Autowired
	private VechicleService vechicleService;

	@GetMapping(value = "/getalldetails")
	public List<VehicleModel> getalldetails() {		
		return vechicleService.getParkedHistory();
	}
	
	@GetMapping(value = "/getbyid/{id}")
	public VehicleModel getbyId(@PathVariable("id") String id) {		
		return vechicleService.getVechilesById(id);
	}
	
	

}
