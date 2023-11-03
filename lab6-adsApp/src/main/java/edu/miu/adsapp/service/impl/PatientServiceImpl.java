package edu.miu.adsapp.service.impl;

import edu.miu.adsapp.model.Patient;
import edu.miu.adsapp.repository.PatientRepository;
import edu.miu.adsapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient addNewPatient(Patient newPatient) {

        return patientRepository.save(newPatient);
    }

    @Override
    public Patient getPatientId(Integer patientId) {
        return patientRepository.findById(patientId)
                .orElse(null);
    }

    @Override
    public Patient updatePatient(Patient editedPatient) {

        return patientRepository.save(editedPatient);
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<Patient> getPatientByFirstNameStart(String firstNameStart) {
        return patientRepository.findPatientByFirstNameIsStartingWith(firstNameStart);
    }
}

