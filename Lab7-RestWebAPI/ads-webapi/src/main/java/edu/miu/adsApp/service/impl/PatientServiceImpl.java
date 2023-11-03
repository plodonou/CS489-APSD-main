package edu.miu.adsApp.service.impl;

import edu.miu.adsApp.dto.address.AddressResponse;
import edu.miu.adsApp.dto.patient.PatientResponse;
import edu.miu.adsApp.exception.PatientNotFoundException;
import edu.miu.adsApp.model.Patient;
import edu.miu.adsApp.repository.AddressRepository;
import edu.miu.adsApp.repository.PatientRepository;
import edu.miu.adsApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private AddressRepository addressRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll(Sort.by("lastName"))
                .stream()
                .map(p -> new PatientResponse(
                        p.getPatientId(),
                        p.getPatNo(),
                        p.getFirstName(),
                        p.getLastName(),
                        new AddressResponse(
                                p.getPrimaryAddress().getAddressId(),
                        p.getPrimaryAddress().getStreet(),
                        p.getPrimaryAddress().getCity(),
                        p.getPrimaryAddress().getState(),
                        p.getPrimaryAddress().getZipCode()
                )
                )).toList();
    }
    @Override
    public Patient addNewPatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }

    @Override
    public Patient getPatientId(Integer patientId) throws PatientNotFoundException {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found",
                        patientId)));
    }

    @Override
    public Patient updatePatient(Integer patientId, Patient editedPatient) {
        var patient = patientRepository.findById(patientId).orElse(null);

        System.out.println("find patient by id: "+patient);
        if(patient != null) {
            patient.setFirstName(editedPatient.getFirstName());
            patient.setLastName(editedPatient.getLastName());
            var address = patient.getPrimaryAddress();
            address.setStreet(editedPatient.getPrimaryAddress().getStreet());
            address.setStreet(editedPatient.getPrimaryAddress().getCity());
            address.setStreet(editedPatient.getPrimaryAddress().getState());
            address.setStreet(editedPatient.getPrimaryAddress().getZipCode());
            return patientRepository.save(patient);
        } else {
            return patient;
        }
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public void deletePatientAddressById(Integer patientId) {
        var patient = patientRepository.findById(patientId).orElse(null);
        if(patient != null) {
            var address = patient.getPrimaryAddress();
            if(address != null) {
//                addressRepository.deleteById(address.getAddressId());
//                patient.setPrimaryAddress(null);
//                patientRepository.save(patient);

                patient.setPrimaryAddress(null);
                patientRepository.save(patient);
                addressRepository.deleteById(address.getAddressId());
            }
        }
    }

//    @Override
//    public List<Patient> getPatientByFirstNameStart(String firstNameStart) {
//        return patientRepository.findPatientByFirstNameIsStartingWith(firstNameStart);
//    }

    @Override
    public List<Patient> searchPatient(String searchString) {
        return patientRepository.findPatientsByFirstNameContainingOrPrimaryAddress_CityContaining(
                searchString, searchString
        );
    }

//    @Override
//    public List<Patient> searchPatient(String searchString) {
//        return patientRepository.findPatientsByFirstNameContainingOrPrimaryAddress_CityContaining(
//                searchString
//        );
//    }
}

