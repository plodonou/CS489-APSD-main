package edu.miu.adsApp.service.impl;

import edu.miu.adsApp.dto.address.AddressResponse2;
import edu.miu.adsApp.dto.patient.PatientResponse2;
import edu.miu.adsApp.model.Address;
import edu.miu.adsApp.repository.AddressRepository;
import edu.miu.adsApp.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressResponse2> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressResponse2(
                        a.getAddressId(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        new PatientResponse2(
                                a.getPatient().getPatientId(),
                                a.getPatient().getPatNo(),
                                a.getPatient().getFirstName(),
                                a.getPatient().getLastName()
                        )
                )).toList();
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public Address getAddressId(Integer addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}
