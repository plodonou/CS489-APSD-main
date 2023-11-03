package edu.miu.adsapp.service;

import edu.miu.adsapp.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient addNewPatient(Patient newPatient);

    Patient getPatientId(Integer patientId);

    Patient updatePatient(Patient editedPatient);

    void deletePatientById(Integer patientId);

    List<Patient> getPatientByFirstNameStart(String firstNameStart);
}
