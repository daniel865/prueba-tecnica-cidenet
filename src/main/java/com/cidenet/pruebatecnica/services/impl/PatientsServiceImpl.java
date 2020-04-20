package com.cidenet.pruebatecnica.services.impl;

import com.cidenet.pruebatecnica.model.Patient;
import com.cidenet.pruebatecnica.persistence.PatientRepository;
import com.cidenet.pruebatecnica.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientsServiceImpl implements PatientsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createOrUpdatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findPatientByPatientId(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public void delete(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
