package edu.miu.adsapp.service.impl;

import edu.miu.adsapp.model.Address;
import edu.miu.adsapp.repository.AddressRepository;
import edu.miu.adsapp.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public Address getAddressId(Integer addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }
}
