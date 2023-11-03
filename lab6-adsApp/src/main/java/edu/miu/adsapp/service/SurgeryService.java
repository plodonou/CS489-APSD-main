package edu.miu.adsapp.service;

import edu.miu.adsapp.model.Surgery;

import java.util.List;

public interface SurgeryService {

    List<Surgery> getAllSurgeries();

    Surgery addNewSurgery (Surgery newSurgery);


}
