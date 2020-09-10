package com.parkinglot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (
	    value       = "ParkingMeta Model",
	    description = "This is a ParkingMeta entity."
	)
public class ParkingMetaModel {
	
	@ApiModelProperty(value = "3", example = "3")
	private Integer parkingCapacity;
	
	@ApiModelProperty(value = "40", example = "40")
	private Double chargePerSecond;

	public Integer getParkingCapacity() {
		return parkingCapacity;
	}

	public void setParkingCapacity(Integer parkingCapacity) {
		this.parkingCapacity = parkingCapacity;
	}

	public Double getChargePerSecond() {
		return chargePerSecond;
	}

	public void setChargePerSecond(Double chargePerSecond) {
		this.chargePerSecond = chargePerSecond;
	}

	

}
