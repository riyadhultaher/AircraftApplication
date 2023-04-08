package com.freyasystems.AircraftProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freyasystems.AircraftProject.model.AircraftProjectRequest;
import com.freyasystems.AircraftProject.model.AircraftProjectResponse;
import com.freyasystems.AircraftProject.service.AircraftProjectService;

@RestController
@RequestMapping("/aircraftProject")
public class AircraftProjectController {
	
	@Autowired
	AircraftProjectService aircraftProjectService;
	
	@RequestMapping(value = "/retrieveAircrafts")
	public AircraftProjectResponse retrieveAircraftData() {
		return aircraftProjectService.retrieveAircraftData();
	}
	
	@RequestMapping(value = "/createAircraft", method = RequestMethod.POST)
	public AircraftProjectResponse createAircraftData(@RequestBody AircraftProjectRequest aircraftProjectRequest) {
		String createAircraftResponseFlag = aircraftProjectService.createData(aircraftProjectRequest);
		return aircraftProjectService.retrieveAircraftData();
	}
	
	@RequestMapping(value = "/updateAircraft", method = RequestMethod.POST)
	public AircraftProjectResponse updateAircraftData(@RequestBody AircraftProjectRequest aircraftProjectRequest) {
		String updateAircraftResponseFlag = aircraftProjectService.updateData(aircraftProjectRequest);
		return aircraftProjectService.retrieveAircraftData();
	}
	
	@RequestMapping(value = "/deleteAircraft", method = RequestMethod.POST)
	public AircraftProjectResponse deleteAircraftData(@RequestBody AircraftProjectRequest aircraftProjectRequest) {
		String deleteAircraftResponseFlag = aircraftProjectService.deleteData(aircraftProjectRequest);
		return aircraftProjectService.retrieveAircraftData();
	}
}
