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
    IAddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable(value = "personId") int personId) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created AddressBook Data for: ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int personId, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated AddressBook Data for: ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId) {
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully", "person id: " + personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable String city) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookByCity(city);
        ResponseDTO respDTO = new ResponseDTO("Get AddressBookBy by City Successful", addressBookDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortAddressBookByCity() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.sortAddressBookByCity();
        ResponseDTO respDTO = new ResponseDTO("Sort AddressBook by City Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable String state) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By State Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortAddressBookByState() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By State Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getByZip/{zip}")
    public ResponseEntity<ResponseDTO> getAddressBookByZip(@PathVariable String zip) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookByZip(zip);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By Zip Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/sortByZip")
    public ResponseEntity<ResponseDTO> sortAddressBookByZip() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.sortAddressBookByZip();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Zip Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<ResponseDTO> sortAddressBookByName() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.sortAddressBookByName();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Name Successful", addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}