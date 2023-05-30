package com.example.day21excersice.Repository;

import com.example.day21excersice.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {

    Address findAddressById(Integer id);


}
