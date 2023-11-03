package edu.miu.adsAppSecurity.dto.patient;

import edu.miu.adsAppSecurity.dto.address.AddressResponse;

public record PatientResponse2(
        Integer patientId,
        String patNo,
        String firstname,
        String lastname
) {
}
