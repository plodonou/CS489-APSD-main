package edu.miu.adsApp.dto.patient;

import edu.miu.adsApp.dto.address.AddressResponse;

public record PatientResponse2(
        Integer patientId,
        String patNo,
        String firstname,
        String lastname
) {
}
