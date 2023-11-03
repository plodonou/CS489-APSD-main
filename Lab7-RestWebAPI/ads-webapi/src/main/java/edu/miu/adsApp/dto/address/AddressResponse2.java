package edu.miu.adsApp.dto.address;

import edu.miu.adsApp.dto.patient.PatientResponse2;

public record AddressResponse2(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode,
        PatientResponse2 patient
) {
}
