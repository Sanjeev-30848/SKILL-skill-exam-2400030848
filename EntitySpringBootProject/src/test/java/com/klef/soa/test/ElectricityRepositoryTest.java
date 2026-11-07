
package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Electricity;
import com.klef.soa.repository.ElectricityRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ElectricityRepositoryTest
{

    @Autowired
    private ElectricityRepository repository;

    @Test
    void testFindAllElectricity()
    {

        List<Electricity> electricity = repository.findAll();

        assertNotNull(electricity);
        assertFalse(electricity.isEmpty());

        System.out.println("Total Electricity Records: " + electricity.size());
    }

    @Test
    void testFindElectricityById() 
    {
        Optional<Electricity> electricity = repository.findById(1L);

        assertTrue(electricity.isPresent());
        assertEquals(1L, electricity.get().getElectricityBillId());

        System.out.println("Electricity Bill ID: " + electricity.get().getElectricityBillId());
        System.out.println("Holder Name: " + electricity.get().getHolderName());
    }

    @Test
    void testFindElectricityByHolderName() 
    {
        List<Electricity> electricity = repository.findByHolderName("Sanjeev");

        assertNotNull(electricity);
        assertFalse(electricity.isEmpty());

        System.out.println("Holder Name: " + electricity.get(0).getHolderName());
    }

    @Test
    void testFindElectricityByType() 
    {
        List<Electricity> electricity = repository.findByType("Domestic");

        assertNotNull(electricity);
        assertFalse(electricity.isEmpty());

        System.out.println("Electricity Type: " + electricity.get(0).getType());
    }

    @Test
    void testDatabaseConnection()
    {
        long count = repository.count();

        assertTrue(count >= 0);

        System.out.println("Total Electricity Records in Database: " + count);
    }
}
