package edu.miu.adsAppSecurity.service;

import edu.miu.adsAppSecurity.dto.address.AddressResponse2;
import edu.miu.adsAppSecurity.model.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse2> getAllAddresses();
    Address addNewAddress(Address newAddress);

    Address getAddressId(Integer addressId);

    void deleteAddressById(Integer addressId);
}
