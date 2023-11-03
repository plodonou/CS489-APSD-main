package edu.miu.adsAppSecurity.dto.patient;

import edu.miu.adsAppSecurity.dto.address.AddressResponse;

public record PatientResponse(
        Integer patientId,
        String patNo,
        String firstname,
        String lastname,
        AddressResponse primaryAddress) {
}
