package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.AddressBookDTO;
import lombok.Data;

@Data
public class AddressBookData {
    private  int personId;

    private String name;

    private String phNumber;

    public AddressBookData(int personId, AddressBookDTO addressBookDTO) {
        this.personId = personId;
        this.name=addressBookDTO.name;
        this.phNumber= addressBookDTO.phNumber;
    }



    @Override
    public String toString() {
        return "AddressbookData{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", phNumber='" + phNumber + '\'' +
                '}';
    }
}