package com.bridgelabz.addressbook.dto;
import lombok.Data;

import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "name is Invalid")
    public String name;
    public String phNumber;

    public AddressBookDTO(String name, String phNumber) {
        this.name = name;
        this.phNumber = phNumber;
    }

}


		

