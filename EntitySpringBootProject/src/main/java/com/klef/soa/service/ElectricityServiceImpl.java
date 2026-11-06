package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Electricity;
import com.klef.soa.repository.ElectricityRepository;

@Service
public class ElectricityServiceImpl implements ElectricityService
{
	@Autowired
	private ElectricityRepository repo;

	@Override
	public Electricity addElectricity(Electricity e)
	{
		return repo.save(e);
	}

	@Override
	public Electricity updateElectricity(Electricity e)
	{
		Optional<Electricity> optional = repo.findById(e.getElectricityBillId());

		if(optional.isPresent())
		{
			Electricity electricity = optional.get();

			electricity.setHolderName(e.getHolderName());
			electricity.setType(e.getType());
			electricity.setStatus(e.getStatus());
			electricity.setLocation(e.getLocation());

			return repo.save(electricity);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Electricity> displayAllElectricity()
	{
		return repo.findAll();
	}

	@Override
	public Electricity displayElectricityById(Long id)
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteElectricityById(Long id)
	{
		boolean flag = repo.existsById(id);

		if(flag)
		{
			repo.deleteById(id);
			return "Electricity Bill Deleted Successfully";
		}
		else
		{
			return "Electricity Bill ID Not Found";
		}
	}

	@Override
	public List<Electricity> findByHolderName(String holderName)
	{
	    return repo.findByHolderName(holderName);
	}


	@Override
	public List<Electricity> findByType(String type)
	{
	    return repo.findByType(type);
	}
}