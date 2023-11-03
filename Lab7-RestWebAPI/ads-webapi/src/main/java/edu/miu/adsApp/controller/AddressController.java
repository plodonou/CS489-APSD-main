package edu.miu.adsApp.controller;

import edu.miu.adsApp.dto.address.AddressResponse2;
import edu.miu.adsApp.model.Address;
import edu.miu.adsApp.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

//    @GetMapping(value = "/adsApp/api/v1/address/list")
//    public List<AddressResponse2> listAddress() {
//        return addressService.getAllAddresses();
//    };

    @GetMapping(value = "/adsApp/api/v1/address/list")
    public ResponseEntity<List<AddressResponse2>> listAddress() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }


}
