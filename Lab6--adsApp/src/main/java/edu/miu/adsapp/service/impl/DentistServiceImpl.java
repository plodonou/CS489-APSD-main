package edu.miu.adsapp.service.impl;

import edu.miu.adsapp.model.Dentist;
import edu.miu.adsapp.repository.DentistRepository;
import edu.miu.adsapp.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {

        this.dentistRepository = dentistRepository;
    }

    @Override
    public List<Dentist> getAllDentists() {

        return dentistRepository.findAll();
    }

    @Override
    public Dentist addNewDentist(Dentist newDentist) {

        return dentistRepository.save(newDentist);
    }

    @Override
    public Dentist getDentistId(Integer dentistId) {
        return dentistRepository.findById(dentistId).orElse(null);
    }

    @Override
    public Dentist updateDentist(Dentist editedDentist) {
        return dentistRepository.save(editedDentist);
    }

    @Override
    public List<Dentist> getDentistByFirstName(String firstNameStart) {
        return dentistRepository.findDentistByFirstNameIsStartingWith(firstNameStart);
    }

}
