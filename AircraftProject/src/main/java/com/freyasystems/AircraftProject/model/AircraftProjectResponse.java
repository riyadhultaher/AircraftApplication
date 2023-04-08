package com.freyasystems.AircraftProject.model;

import java.io.Serializable;

import java.util.List;

public class AircraftProjectResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	List<Aircraft> aircrafts;
	
	List<AircraftType> aircraftTypes;

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

	public List<AircraftType> getAircraftTypes() {
		return aircraftTypes;
	}

	public void setAircraftTypes(List<AircraftType> aircraftTypes) {
		this.aircraftTypes = aircraftTypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aircraftTypes == null) ? 0 : aircraftTypes.hashCode());
		result = prime * result + ((aircrafts == null) ? 0 : aircrafts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AircraftProjectResponse other = (AircraftProjectResponse) obj;
		if (aircraftTypes == null) {
			if (other.aircraftTypes != null)
				return false;
		} else if (!aircraftTypes.equals(other.aircraftTypes))
			return false;
		if (aircrafts == null) {
			if (other.aircrafts != null)
				return false;
		} else if (!aircrafts.equals(other.aircrafts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AircraftProjectResponse [aircrafts=" + aircrafts + ", aircraftTypes=" + aircraftTypes + "]";
	}
}
