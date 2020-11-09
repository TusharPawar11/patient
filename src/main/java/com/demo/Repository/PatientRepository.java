package com.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Patient;


public interface PatientRepository extends CrudRepository<Patient, Long>{
	
 @Query("SELECT p FROM Patient p where p.firstName = :firstName")	
public Patient findByFirstName(@Param("firstName") String firstName);
 
 @Query("SELECT p FROM Patient p where p.hospitalId = :hospitalId")	
public List<Patient> findByhospitalId(@Param("hospitalId") long hospitalId);

}
