package com.bridgelabz.addressbook.model;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;

public @Data class AddressBookData {
    private  int personId;

    private String name;

    private String phNumber;

    public AddressBookData(int personId, AddressBookDTO addressBookDTO) {
        this.personId = personId;
        this.name=addressBookDTO.name;
        this.phNumber= addressBookDTO.phNumber;
    }


    }
