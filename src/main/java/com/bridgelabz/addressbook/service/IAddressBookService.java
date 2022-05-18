package com.bridgelabz.addressbook.service;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int personId);

    List<AddressBookData> getAddressBookByCity(String city);

    List<AddressBookData> sortAddressBookByCity();

    List<AddressBookData> getAddressBookByState(String state);

    List<AddressBookData> sortAddressBookByState();

    List<AddressBookData> getAddressBookByZip(String state);

    List<AddressBookData> sortAddressBookByZip();

    List<AddressBookData> sortAddressBookByName();



}


