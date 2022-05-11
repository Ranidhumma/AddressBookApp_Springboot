package com.bridgelabz.addressbook.controller;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*Created a Rest Controller to demonstrate the various HTTP Methods*/

@RestController
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService ;
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success",addressBookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable(value = "personId") int personId) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(personId,new AddressBookDTO("Daniel","123456789"));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: ",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created AddressBook Data for: ",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int personId,@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(personId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated AddressBook Data for: ",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}


