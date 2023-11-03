package edu.miu.adsAppSecurity.dto.patient;

import edu.miu.adsAppSecurity.dto.address.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PatientRequest(
        @NotBlank(message = "Publisher Name is required and cannot be null or empty string or blank spaces")
        String name,
        @Valid AddressRequest primaryAddress
) {
}
