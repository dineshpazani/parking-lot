package com.parkinglot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (
	    value       = "Parking Model",
	    description = "This is a Parking entity."
	)
public class ParkingModel {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(readOnly = true)
	private Integer parkingSlotId;
	
	private VehicleModel vehicleModel;
	

	public Integer getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(Integer parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
	
	
	

}
