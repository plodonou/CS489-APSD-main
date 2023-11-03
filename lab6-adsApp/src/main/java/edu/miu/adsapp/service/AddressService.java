package edu.miu.adsapp.service;

import edu.miu.adsapp.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();
    Address addNewAddress(Address newAddress);

    Address getAddressId(Integer addressId);
}
