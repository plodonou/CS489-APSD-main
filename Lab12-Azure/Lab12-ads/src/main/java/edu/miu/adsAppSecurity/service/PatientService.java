package edu.miu.adsAppSecurity.service;

import edu.miu.adsAppSecurity.dto.patient.PatientResponse;
import edu.miu.adsAppSecurity.exception.PatientNotFoundException;
import edu.miu.adsAppSecurity.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientResponse> getAllPatients();
    Patient addNewPatient(Patient newPatient);

    Patient getPatientId(Integer patientId) throws PatientNotFoundException;


    Patient updatePatient(Integer patientId,Patient editedPatient);

    void deletePatientById(Integer patientId);

    void deletePatientAddressById(Integer patientId);

//    List<Patient> getPatientByFirstNameStart(String firstNameStart);

    List<Patient> searchPatient(String searchString);
}
