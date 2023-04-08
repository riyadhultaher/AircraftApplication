package com.freyasystems.AircraftProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freyasystems.AircraftProject.jpa.AircraftJPA;

@Repository
public interface AircraftRepository extends JpaRepository<AircraftJPA, Integer> {

}
