package edu.miu.adsAppSecurity.dto.address;

import edu.miu.adsAppSecurity.dto.patient.PatientResponse2;

public record AddressResponse2(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode,
        PatientResponse2 patient
) {
}
