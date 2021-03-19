package com.tomgregory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ThemeParkRide {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String description;
	private int thrillFactor;
	private int vomitFactor;
	
	public ThemeParkRide() {
		super();
	}

	public ThemeParkRide(@NotNull String name, @NotNull String description, int thrillFactor, int vomitFactor) {
		super();
		this.name = name;
		this.description = description;
		this.thrillFactor = thrillFactor;
		this.vomitFactor = vomitFactor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getThrillFactor() {
		return thrillFactor;
	}

	public void setThrillFactor(int thrillFactor) {
		this.thrillFactor = thrillFactor;
	}

	public int getVomitFactor() {
		return vomitFactor;
	}

	public void setVomitFactor(int vomitFactor) {
		this.vomitFactor = vomitFactor;
	}
	
	
	
}
