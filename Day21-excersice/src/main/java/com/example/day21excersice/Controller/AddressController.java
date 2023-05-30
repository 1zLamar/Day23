package com.example.day21excersice.Controller;

import com.example.day21excersice.DTO.AddressDTO;
import com.example.day21excersice.Model.Address;
import com.example.day21excersice.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress(){
        List<Address> addresses= addressService.GetAddress();
        return ResponseEntity.status(200).body(addresses);
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO dto) {
        addressService.addAddress(dto);
        return ResponseEntity.status(200).body("address added to teacher");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateAddress(@Valid @RequestBody Address address,@PathVariable Integer id){
        addressService.updateAddress(address,id);
        return ResponseEntity.status(200).body("address updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("address deleted");
    }
}
