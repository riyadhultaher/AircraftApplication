package com.freyasystems.AircraftProject.model;

import com.freyasystems.AircraftProject.jpa.AircraftJPA;
import com.freyasystems.AircraftProject.jpa.AircraftTypeJPA;

public class Aircraft {
	
	private String serialNumber;
	
	private Integer id;
	
	private String missionCapability;
	
	private String location;
	
	private Integer flightHours;
	
	private Integer type;
	
	public Aircraft (AircraftJPA aircraftJPA) {
		this.serialNumber = aircraftJPA.getSerialNumber();
		this.id = aircraftJPA.getId();
		this.missionCapability = aircraftJPA.getMissionCapability();
		this.location = aircraftJPA.getLocation();
		this.flightHours = aircraftJPA.getFlightHours();
		this.type = aircraftJPA.getType();
	}
	
	public Aircraft (String serialNumber, Integer id, String missionCapability, String location, Integer flightHours,
			Integer type) {
		this.serialNumber = serialNumber;
		this.id = id;
		this.missionCapability = missionCapability;
		this.location = location;
		this.flightHours = flightHours;
		this.type = type;
	}

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
}
