package com.freyasystems.AircraftProject.service;

import com.freyasystems.AircraftProject.model.AircraftProjectRequest;
import com.freyasystems.AircraftProject.model.AircraftProjectResponse;

public interface AircraftProjectService {

	AircraftProjectResponse retrieveAircraftData();
	
	String createData(AircraftProjectRequest aircraftProjectRequest);
	
	String updateData(AircraftProjectRequest aircraftProjectRequest);
	
	String deleteData(AircraftProjectRequest aircraftProjectRequest);
}
