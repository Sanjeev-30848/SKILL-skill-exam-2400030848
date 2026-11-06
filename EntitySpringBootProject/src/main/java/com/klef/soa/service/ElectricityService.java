package com.klef.soa.service;

import java.util.List;
import com.klef.soa.entity.Electricity;

public interface ElectricityService
{
	Electricity addElectricity(Electricity e);
	Electricity updateElectricity(Electricity e);
	List<Electricity> displayAllElectricity();
	Electricity displayElectricityById(Long id);
	String deleteElectricityById(Long id);
	public List<Electricity> findByHolderName(String holderName);
	public List<Electricity> findByType(String type);
}