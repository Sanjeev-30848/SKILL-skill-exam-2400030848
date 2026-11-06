package com.klef.soa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Electricity;

public interface ElectricityRepository extends JpaRepository<Electricity, Long>
{
	List<Electricity> findByHolderName(String holderName);
	
	List<Electricity> findByType(String type);
}