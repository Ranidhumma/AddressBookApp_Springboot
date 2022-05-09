package com.bridgelabz.addressbook.controller;
import com.bridgelabz.addressbook.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*Created a Rest Controller to demonstrate the various HTTP Methods*/

@RestController
public class AddressBookController {
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<String> getAddressBookData(@PathVariable(value = "personId") int personId) {
        return new ResponseEntity<String>("Get Call Success for id: " + personId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookData(@RequestBody AddressBookDTO addressbookDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data for: " + addressbookDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressbookDTO) {
        return new ResponseEntity<String>("Updated Employee Payroll Data for: " + addressbookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId){
        return new ResponseEntity<String>("Delete Call Success for id: " + personId, HttpStatus.OK);

    }

}


