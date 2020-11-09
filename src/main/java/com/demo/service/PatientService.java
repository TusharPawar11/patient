package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.Repository.PatientRepository;
import com.demo.model.Patient;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	 public List<Patient> getPatients()  {
		 
		List<Patient> patientList = (List<Patient>) patientRepository.findAll();
		return patientList;
    }

	
	public Optional<Patient> findPatient(long id) {
	
		Optional<Patient> patient= patientRepository.findById(id);
	    return patient;
	}

	 public Patient addPatients(Patient patient)  {
		
		return patientRepository.save(patient);		
	 }

	public void deletePatient(long id) {

		patientRepository.deleteById(id);
	}

	 public Patient updatePatient(@RequestBody Patient patient , @PathVariable("id") long id) {
		
		patient=  patientRepository.save(patient);	
		return patient;
    }


	public Patient findByFirstName(String firstName) {
	 
		return patientRepository.findByFirstName(firstName);
	}


	public List<Patient> findByhospitalId(long hospitalId) {
		
		return patientRepository.findByhospitalId(hospitalId);
	}



}
