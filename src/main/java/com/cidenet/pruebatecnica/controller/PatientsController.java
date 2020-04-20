package com.cidenet.pruebatecnica.controller;

import com.cidenet.pruebatecnica.exceptions.CidenetBadRequestException;
import com.cidenet.pruebatecnica.exceptions.ExceptionStatus;
import com.cidenet.pruebatecnica.model.Patient;
import com.cidenet.pruebatecnica.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("patients")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Patient findByPatientId(@PathVariable("id") Long id) {
        return patientsService.findPatientByPatientId(id)
                .orElseThrow(() -> new CidenetBadRequestException(ExceptionStatus.NOT_FOUND_PATIENT));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@RequestBody Patient patient) {
        patient.validate();
        patientsService.createOrUpdatePatient(patient);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
        return patientsService.findPatientByPatientId(id)
                .flatMap(foundPatient ->
                        Optional.of(patientsService.createOrUpdatePatient(foundPatient)
                                .getPatientId())
                )
                .orElseThrow(() -> new CidenetBadRequestException(ExceptionStatus.NOT_FOUND_PATIENT));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePatient(@PathVariable("id") Long id) {
        patientsService.findPatientByPatientId(id)
                .ifPresent(foundPatient ->
                        patientsService.delete(id)
                );
    }


}
