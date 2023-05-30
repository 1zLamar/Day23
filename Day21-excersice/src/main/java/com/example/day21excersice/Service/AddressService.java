package com.example.day21excersice.Service;

import com.example.day21excersice.ApiException.ApiException;
import com.example.day21excersice.DTO.AddressDTO;
import com.example.day21excersice.Model.Address;
import com.example.day21excersice.Model.Teacher;
import com.example.day21excersice.Repository.AddressRepository;
import com.example.day21excersice.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final TeacherRepository teacherRepository;

    private final AddressRepository addressRepository;

    public List<Address> GetAddress(){
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO dto){
        Teacher teacher=teacherRepository.findTeacherById(dto.getAddressId());
        if(teacher==null){
            throw new ApiException("can't add address the teacher is not found");
        }
        Address address=new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Address address,Integer id){
        Address address1=addressRepository.findAddressById(id);
        if(address1==null){
            throw new ApiException("not found");
        }

        address1.setArea(address.getArea());
        address1.setStreet(address.getStreet());
        address1.setBuildingNumber(address.getBuildingNumber());

        addressRepository.save(address1);
    }

    public void deleteAddress(Integer id){
        Address address=addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("not found");
        }
        addressRepository.delete(address);
    }

}
