package com.freyasystems.AircraftProject.util;

import java.util.Comparator;

import com.freyasystems.AircraftProject.model.AircraftType;

public class SortAircraftType implements Comparator<AircraftType> {
	
	@Override
	public int compare(AircraftType o1, AircraftType o2) {
		return o1.getTypeId() - o2.getTypeId();
	}
}
