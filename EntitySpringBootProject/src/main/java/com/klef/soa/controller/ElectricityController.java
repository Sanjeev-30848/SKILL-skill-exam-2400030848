package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Electricity;
import com.klef.soa.service.ElectricityService;

@RestController
@RequestMapping("/electricity")
public class ElectricityController
{
	@Autowired
	private ElectricityService service;

	@GetMapping("/")
	public String demo()
	{
		return "Spring Boot Electricity Task Entity Project - 2400030848";
	}

	// Add Electricity Bill
	@PostMapping("/add")
	public ResponseEntity<Electricity> addElectricity(@RequestBody Electricity e)
	{
		Electricity electricity = service.addElectricity(e);
		return ResponseEntity.status(201).body(electricity);
	}

	// Display All Electricity Bills
	@GetMapping("/displayall")
	public ResponseEntity<List<Electricity>> displayAllElectricity()
	{
		List<Electricity> electricityList = service.displayAllElectricity();
		return ResponseEntity.status(200).body(electricityList);
	}

	// Display Electricity Bill By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayElectricityById(@RequestParam Long id)
	{
		Electricity electricity = service.displayElectricityById(id);

		if (electricity != null)
		{
			return ResponseEntity.status(200).body(electricity);
		}
		else
		{
			return ResponseEntity.status(404).body("Electricity Bill ID Not Found");
		}
	}

	// Update Electricity Bill
	@PutMapping("/update")
	public ResponseEntity<?> updateElectricity(@RequestBody Electricity electricity)
	{
		Electricity e = service.updateElectricity(electricity);

		if (e != null)
		{
			return ResponseEntity.ok(e);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Electricity Bill ID Not Found");
		}
	}

	// Delete Electricity Bill By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteElectricityById(@PathVariable Long id)
	{
		String message = service.deleteElectricityById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	// Find Electricity Bills by Holder Name
	@GetMapping("/findbyholdername")
	public ResponseEntity<?> findByHolderName(@RequestParam String holderName)
	{
	    List<Electricity> list = service.findByHolderName(holderName);

	    if(list.isEmpty())
	    {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("No Electricity Bills Found for Holder Name : " + holderName);
	    }

	    return ResponseEntity.ok(list);
	}

	// Find Electricity Bills by Type
	@GetMapping("/findbytype")
	public ResponseEntity<?> findByType(@RequestParam String type)
	{
	    List<Electricity> list = service.findByType(type);

	    if(list.isEmpty())
	    {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("No Electricity Bills Found for Type : " + type);
	    }

	    return ResponseEntity.ok(list);
	}
}