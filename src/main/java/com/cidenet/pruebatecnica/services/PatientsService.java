package com.cidenet.pruebatecnica.services;

import com.cidenet.pruebatecnica.model.Patient;

import java.util.Optional;

public interface PatientsService {

    Patient createOrUpdatePatient(Patient patient);

    Optional<Patient> findPatientByPatientId(Long patientId);

    void delete(Long patientId);
}
