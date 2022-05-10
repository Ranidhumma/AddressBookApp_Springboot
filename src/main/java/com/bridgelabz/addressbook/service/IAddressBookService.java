package com.bridgelabz.addressbook.service;
import com.bridgelabz.addressbook.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int personId);
}

