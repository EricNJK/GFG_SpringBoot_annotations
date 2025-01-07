package com.gfg.spring.transactions.service;

import com.gfg.spring.transactions.model.Address;
import com.gfg.spring.transactions.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
