package com.bridgelabz.addressbook.service;
import com.bridgelabz.addressbook.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        addressBookDataList.add(new AddressBookData(1,new AddressBookDTO("Rani","1234567891")));
        return addressBookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
            AddressBookData addressBookData = null;
            addressBookData = new AddressBookData(personId, new AddressBookDTO("Raj", "123456789"));
            return addressBookData;
        }
        public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO){
            AddressBookData addressBookData = null;
            addressBookData = new AddressBookData(1, addressBookDTO);
            return addressBookData;
        }

        public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO){
            AddressBookData addressBookData = null;
            addressBookData = new AddressBookData(personId, addressBookDTO);
            return addressBookData;
        }


        public void deleteAddressBookData(int personId){

        }

    }

