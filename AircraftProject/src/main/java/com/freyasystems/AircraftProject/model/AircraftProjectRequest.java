package com.freyasystems.AircraftProject.model;

import java.io.Serializable;

import com.freyasystems.AircraftProject.jpa.AircraftJPA;
import com.freyasystems.AircraftProject.jpa.AircraftTypeJPA;

public class AircraftProjectRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String serialNumber;
	
	private Integer id;
	
	private String missionCapability;
	
	private String location;
	
	private Integer flightHours;
	
	private Integer type;
	
	private Integer typeId;
	
	private String description;
	
	private String model;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMissionCapability() {
		return missionCapability;
	}

	public void setMissionCapability(String missionCapability) {
		this.missionCapability = missionCapability;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(Integer flightHours) {
		this.flightHours = flightHours;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
