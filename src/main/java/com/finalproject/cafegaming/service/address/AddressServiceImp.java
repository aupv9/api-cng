package com.finalproject.cafegaming.service.address;

import com.finalproject.cafegaming.dao.AddressRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AddressServiceImp implements AddressService{

    final AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable).getContent();
    }

    @Override
    public Boolean save(Address district) {
        district.setCreateAt(LocalDateTime.now());
        district.setUpdateAt(LocalDateTime.now());
        return addressRepository.save(district) instanceof Address;
    }

    @Override
    public Boolean update(Address address) {
        Address address1 = findById(address.getId());
        address1.setProvince(address.getProvince());
        address1.setDisctrict(address.getDisctrict());
        address1.setStreet(address.getStreet());
        address1.setWard(address.getWard());
        address1.setNumber(address.getNumber());
        address1.setUpdateAt(LocalDateTime.now());

        return addressRepository.save(address1) instanceof Address;
    }

    @Override
    public Boolean delete(String id) {
        Address address = findById(id);
        address.setStatus("CLOSE");
        address.setUpdateAt(LocalDateTime.now());
        return addressRepository.save(address) instanceof Address;
    }

    @Override
    public Address findById(String s) {
        return addressRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
