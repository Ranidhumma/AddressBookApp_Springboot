package com.bridgelabz.addressbook.model;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;

public @Data class AddressBookData {
    private  int personId;
    private String firstName;
    private String lastName;
    private String phNumber;
    private  String address;
    private  String city;
    private  String state;

    private  String zip;
    private String email;


    public AddressBookData(int personId, AddressBookDTO addressBookDTO) {
        this.personId = personId;
        this.updateAddressBookdata(addressBookDTO);
    }

    public void updateAddressBookdata(AddressBookDTO addressBookDTO) {
        this.personId = personId;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.phNumber = addressBookDTO.phNumber;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip = addressBookDTO.zip;
        this.email = addressBookDTO.email;

    }
}
