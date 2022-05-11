package com.bridgelabz.addressbook.dto;
import lombok.Data;

public @Data class AddressBookDTO {
    public String name;
    public String phNumber;

    public AddressBookDTO(String name, String phNumber) {
        this.name = name;
        this.phNumber = phNumber;
    }

}


		

