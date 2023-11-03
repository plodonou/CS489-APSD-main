package edu.miu.adsAppSecurity.dto.address;

public record AddressResponse(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode) {
}
