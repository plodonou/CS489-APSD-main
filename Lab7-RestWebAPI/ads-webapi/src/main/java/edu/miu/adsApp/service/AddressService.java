package edu.miu.adsApp.service;

import edu.miu.adsApp.dto.address.AddressResponse2;
import edu.miu.adsApp.model.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse2> getAllAddresses();
    Address addNewAddress(Address newAddress);

    Address getAddressId(Integer addressId);

    void deleteAddressById(Integer addressId);
}
