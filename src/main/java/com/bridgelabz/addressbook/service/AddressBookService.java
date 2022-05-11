package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookDataList;
    }

    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookDataList.stream()
                .filter(addressBookData -> addressBookData.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Address Book ID Not Found"));
    }

    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        //dressBookDataList.add(addressBookData);
        addressBookData = new AddressBookData(addressBookDataList.size() + 1, addressBookDTO);
        log.debug("AddressBookData: " + addressBookData.toString());
        addressBookDataList.add(addressBookData);
        return addressBookRepository.save(addressBookData);

    }

    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.updateAddressBookdata(addressBookDTO);
        addressBookDataList.set(personId - 1, addressBookData);
        return addressBookData;
    }


    public void deleteAddressBookData(int personId) {
        int i = 1;
        addressBookDataList.remove(personId - 1);
        for (AddressBookData addressBookData : addressBookDataList) {
            addressBookData.setPersonId(i++);

        }
    }
}

















