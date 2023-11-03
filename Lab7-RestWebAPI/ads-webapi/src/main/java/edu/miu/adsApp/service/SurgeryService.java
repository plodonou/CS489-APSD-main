package edu.miu.adsApp.service;

import edu.miu.adsApp.model.Surgery;

import java.util.List;

public interface SurgeryService {

    List<Surgery> getAllSurgeries();

    Surgery addNewSurgery (Surgery newSurgery);

    Surgery getSurgeryId (Integer surgeryId);


}
