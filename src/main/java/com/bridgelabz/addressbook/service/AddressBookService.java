package com.bridgelabz.addressbook.service;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
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

//            AddressBookData addressBookData = null;
//            addressBookData = addressBookDataList.get(personId - 1);
//            return addressBookData;
        }

        public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO){
            AddressBookData addressBookData = null;
            addressBookData = new AddressBookData(addressBookDataList.size() + 1, addressBookDTO);
            addressBookDataList.add(addressBookData);
            return addressBookData;
        }

        public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO){
            AddressBookData addressBookData = this.getAddressBookDataById(personId);
            addressBookData.setName(addressBookDTO.name);
            addressBookData.setPhNumber(addressBookDTO.phNumber);
            addressBookDataList.set(personId - 1, addressBookData);
            return addressBookData;
        }


        public void deleteAddressBookData(int personId){
            int i = 1;
            addressBookDataList.remove(personId - 1);
            for (AddressBookData addressBookData : addressBookDataList) {
                addressBookData.setPersonId(i++);
            }
        }

        }


















