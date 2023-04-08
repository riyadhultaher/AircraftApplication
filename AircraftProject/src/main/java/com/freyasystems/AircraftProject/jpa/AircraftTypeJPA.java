package com.freyasystems.AircraftProject.jpa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table (name = "\"AircraftType\"")
public class AircraftTypeJPA implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column (name = "\"TypeId\"", unique = true)
	@Id
	@NonNull
	private Integer typeId;
	
	@Column (name = "\"Description\"")
	@NonNull
	private String description;
	
	@Column (name = "\"Model\"", unique = true)
	@NonNull
	private String model;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "\"TypeId\"", referencedColumnName = "\"Type\"")
	private AircraftJPA aircraftJPA;
	
	public AircraftTypeJPA () {
		
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

	public AircraftJPA getAircraftJPA() {
		return aircraftJPA;
	}

	public void setAircraftJPA(AircraftJPA aircraftJPA) {
		this.aircraftJPA = aircraftJPA;
	}
}
