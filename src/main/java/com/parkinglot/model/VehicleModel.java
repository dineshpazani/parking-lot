package com.parkinglot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;;

@ApiModel (
	    value       = "Vehicle Model",
	    description = "This is a Vehicle entity."
	)
public class VehicleModel {
	
	private String vahicleNo;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(readOnly = true)
	private Integer parkingSlotId;
		
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(readOnly = true)
	private LocalDateTime inTime;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(readOnly = true)
	private LocalDateTime outTime;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(readOnly = true)
	private Integer parkedTime;	
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(readOnly = true)
	private Double charged;

	public String getVahicleNo() {
		return vahicleNo;
	}

	public void setVahicleNo(String vahicleNo) {
		this.vahicleNo = vahicleNo;
	}	

	public LocalDateTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}

	public LocalDateTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}

	public Integer getParkedTime() {
		return parkedTime;
	}

	public void setParkedTime(Integer parkedTime) {
		this.parkedTime = parkedTime;
	}

	public Double getCharged() {
		return charged;
	}

	public void setCharged(Double charged) {
		this.charged = charged;
	}

	public Integer getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(Integer parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	

}
