package com.freyasystems.AircraftProject.model;

import com.freyasystems.AircraftProject.jpa.AircraftJPA;
import com.freyasystems.AircraftProject.jpa.AircraftTypeJPA;

public class AircraftType {
	
	private Integer typeId;
	
	private String description;
	
	private String model;
	
	public AircraftType (AircraftTypeJPA aircraftTypeJPA) {
		this.typeId = aircraftTypeJPA.getTypeId();
		this.description = aircraftTypeJPA.getDescription();
		this.model = aircraftTypeJPA.getModel();
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
