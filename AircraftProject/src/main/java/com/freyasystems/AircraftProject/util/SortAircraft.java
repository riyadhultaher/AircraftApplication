package com.freyasystems.AircraftProject.util;

import java.util.Comparator;

import com.freyasystems.AircraftProject.model.Aircraft;

public class SortAircraft implements Comparator<Aircraft> {

	@Override
	public int compare(Aircraft o1, Aircraft o2) {
		return o1.getId() - o2.getId();
	}

}
