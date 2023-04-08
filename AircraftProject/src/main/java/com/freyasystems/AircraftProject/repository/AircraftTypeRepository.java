package com.freyasystems.AircraftProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freyasystems.AircraftProject.jpa.AircraftTypeJPA;

@Repository
public interface AircraftTypeRepository extends JpaRepository<AircraftTypeJPA, Integer> {

}
