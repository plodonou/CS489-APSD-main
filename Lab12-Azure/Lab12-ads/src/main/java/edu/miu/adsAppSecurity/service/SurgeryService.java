package edu.miu.adsAppSecurity.service;

import edu.miu.adsAppSecurity.model.Surgery;

import java.util.List;

public interface SurgeryService {

    List<Surgery> getAllSurgeries();

    Surgery addNewSurgery (Surgery newSurgery);

    Surgery getSurgeryId (Integer surgeryId);


}
