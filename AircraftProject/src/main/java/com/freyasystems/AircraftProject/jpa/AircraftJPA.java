package com.freyasystems.AircraftProject.jpa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

@Entity
@Table (name = "\"Aircraft\"")
public class AircraftJPA implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column (name = "\"Serial_Number\"")
	@NonNull
	private String serialNumber;
	
	@Column (name = "\"Id\"")
	@Id
	@NonNull
	private Integer id;
	
	@Column (name = "\"MissionCapability\"")
	@NonNull
	@Value("FMC")
	private String missionCapability;
	
	@Column (name = "\"Location\"")
	private String location;
	
	@Column (name = "\"FlightHours\"")
	private Integer flightHours;
	
	@NonNull
	@Column (name = "\"Type\"")
	private Integer type;
	
	public AircraftJPA () {
		
	}
	
	public AircraftJPA (String serialNumber, Integer id, String missionCapability, String location, Integer flightHours,
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
