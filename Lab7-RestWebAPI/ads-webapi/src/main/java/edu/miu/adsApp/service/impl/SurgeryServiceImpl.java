package edu.miu.adsApp.service.impl;

import edu.miu.adsApp.model.Surgery;
import edu.miu.adsApp.repository.SurgeryRepository;
import edu.miu.adsApp.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery addNewSurgery(Surgery newSurgery) {
        return surgeryRepository.save(newSurgery);
    }


    @Override
    public Surgery getSurgeryId(Integer surgeryId) {
        return surgeryRepository.findById(surgeryId).orElse(null);
    }
}
