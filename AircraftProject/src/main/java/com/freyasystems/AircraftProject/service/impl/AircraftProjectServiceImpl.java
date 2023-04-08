package com.freyasystems.AircraftProject.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freyasystems.AircraftProject.constants.AircraftProjectConstants;
import com.freyasystems.AircraftProject.jpa.AircraftJPA;
import com.freyasystems.AircraftProject.jpa.AircraftTypeJPA;
import com.freyasystems.AircraftProject.model.Aircraft;
import com.freyasystems.AircraftProject.model.AircraftProjectRequest;
import com.freyasystems.AircraftProject.model.AircraftProjectResponse;
import com.freyasystems.AircraftProject.model.AircraftType;
import com.freyasystems.AircraftProject.repository.AircraftRepository;
import com.freyasystems.AircraftProject.repository.AircraftTypeRepository;
import com.freyasystems.AircraftProject.service.AircraftProjectService;
import com.freyasystems.AircraftProject.util.SortAircraft;
import com.freyasystems.AircraftProject.util.SortAircraftType;

@Service
@Transactional
public class AircraftProjectServiceImpl implements AircraftProjectService {

	@Autowired
	AircraftRepository aircraftRepository;

	@Autowired
	AircraftTypeRepository aircraftTypeRepository;

	@Override
	public AircraftProjectResponse retrieveAircraftData() {
		AircraftProjectResponse aircraftProjectResponse = new AircraftProjectResponse();

		List<Aircraft> aircrafts = new ArrayList<Aircraft>();
		List<AircraftType> aircraftTypes = new ArrayList<AircraftType>();

		List<AircraftJPA> aircraftJPAs = aircraftRepository.findAll();
		List<AircraftTypeJPA> aircraftTypeJPAs = aircraftTypeRepository.findAll();

		for (AircraftJPA aircraftJPA : aircraftJPAs) {
			aircrafts.add(new Aircraft(aircraftJPA));
		}

		for (AircraftTypeJPA aircraftTypeJPA : aircraftTypeJPAs) {
			aircraftTypes.add(new AircraftType(aircraftTypeJPA));
		}
		
		sortAircraftData(aircrafts);
		sortAircraftTypeData(aircraftTypes);

		aircraftProjectResponse.setAircrafts(aircrafts);
		aircraftProjectResponse.setAircraftTypes(aircraftTypes);

		return aircraftProjectResponse;
	}

	@Override
	public String createData(AircraftProjectRequest aircraftProjectRequest) {
		try {
			if (aircraftRepository.existsById(aircraftProjectRequest.getId())) {
				throw new Exception();
			}
			AircraftTypeJPA aircraftTypeJPA = buildAircraftTypeJPA(aircraftProjectRequest);
			AircraftJPA aircraftJPA = buildAircraftJPA(aircraftProjectRequest);

			aircraftTypeRepository.save(aircraftTypeJPA);
			aircraftRepository.save(aircraftJPA);

		} catch (Exception e) {
			return AircraftProjectConstants.ADD_DATA_ERROR;
		}

		return AircraftProjectConstants.ADD_DATA_SUCCESS;
	}

	@Override
	public String updateData(AircraftProjectRequest aircraftProjectRequest) {
		try {
			Boolean validator = aircraftRepository.existsById(aircraftProjectRequest.getId());

			if (validator) {
				AircraftTypeJPA aircraftTypeJPA = buildAircraftTypeJPA(aircraftProjectRequest);
				AircraftJPA aircraftJPA = buildAircraftJPA(aircraftProjectRequest);
				aircraftTypeJPA.setTypeId(aircraftProjectRequest.getTypeId());
				aircraftJPA.setId(aircraftProjectRequest.getId());

				aircraftTypeRepository.save(aircraftTypeJPA);
				aircraftRepository.save(aircraftJPA);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			return AircraftProjectConstants.UPDATE_DATA_ERROR;
		}
		return AircraftProjectConstants.ADD_DATA_SUCCESS;
	}
	
	@Override
	public String deleteData(AircraftProjectRequest aircraftProjectRequest) {
		try {
			aircraftRepository.deleteById(aircraftProjectRequest.getId());
			aircraftTypeRepository.deleteById(aircraftProjectRequest.getTypeId());
		
		} catch (Exception e) {
			return AircraftProjectConstants.DELETE_DATA_ERROR;
		}

		return AircraftProjectConstants.DELETE_DATA_SUCCESS;
	}

	private AircraftJPA buildAircraftJPA(AircraftProjectRequest aircraftProjectRequest) {
		AircraftJPA aircraftJPA = new AircraftJPA();
		aircraftJPA.setFlightHours(aircraftProjectRequest.getFlightHours());
		aircraftJPA.setId(aircraftProjectRequest.getId());
		aircraftJPA.setLocation(aircraftProjectRequest.getLocation());
		aircraftJPA.setMissionCapability(aircraftProjectRequest.getMissionCapability());
		aircraftJPA.setSerialNumber(aircraftProjectRequest.getSerialNumber());
		aircraftJPA.setType(aircraftProjectRequest.getType());
		return aircraftJPA;
	}

	private AircraftTypeJPA buildAircraftTypeJPA(AircraftProjectRequest aircraftProjectRequest) {
		AircraftTypeJPA aircraftTypeJPA = new AircraftTypeJPA();
		aircraftTypeJPA.setDescription(aircraftProjectRequest.getDescription());
		aircraftTypeJPA.setModel(aircraftProjectRequest.getModel());
		aircraftTypeJPA.setTypeId(aircraftProjectRequest.getTypeId());
		return aircraftTypeJPA;
	}
	
	private void sortAircraftData (List<Aircraft> aircrafts) {
		Collections.sort(aircrafts, new SortAircraft());
	}
	
	private void sortAircraftTypeData (List<AircraftType> aircraftTypes) {
		Collections.sort(aircraftTypes, new SortAircraftType());
	}
}
