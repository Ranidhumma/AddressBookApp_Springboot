package com.bridgelabz.addressbook;

public class AddressBookDTO {

    public String name;
    public String phNumber;

    public AddressBookDTO(String name, String phNumber) {
        this.name = name;
        this.phNumber = phNumber;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", phNumber=" + phNumber +
                '}';
    }
}
