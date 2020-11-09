package com.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Patient;
import com.demo.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}


	@RequestMapping(value="/patients" , method = RequestMethod.GET)
    public List<Patient> getPatients() {	
		
		return patientService.getPatients();		
    }

	@RequestMapping(value="/patients/add" , method = RequestMethod.POST)
	 public Patient addPatients(@RequestBody Patient patient) {
		return patientService.addPatients(patient);
		 
	 }
	
	@RequestMapping(value="/patients/{id}" , method = RequestMethod.GET)
	public Optional<Patient> findPatient(@PathVariable("id") long id) {
	
    	return patientService.findPatient(id);	
	}
	
	
	@RequestMapping(value="/patients/{id}" , method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable("id") long id) {
		
		 patientService.deletePatient(id);	
    }
	
	@RequestMapping(value="/patients/{id}" , method = RequestMethod.PUT)
    public Patient updatePatient(@RequestBody Patient patient , @PathVariable("id") long id) {
		
		 return patientService.updatePatient(patient , id);	
    }
	
	@RequestMapping(value="/patientsdetails/{firstName}" , method = RequestMethod.GET)
	public Patient findByFirstName(@PathVariable("firstName") String firstName) {
		return patientService.findByFirstName(firstName);
		
	}
	
	@RequestMapping(value="/patientsInHospital/{hospitalId}"  , method = RequestMethod.GET)
	public List<Patient> findByhospitalId(@PathVariable("hospitalId") long hospitalId) {
		
		return patientService.findByhospitalId(hospitalId);
		
	}
}
