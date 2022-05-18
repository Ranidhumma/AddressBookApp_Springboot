package com.bridgelabz.addressbook.service;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * @Purpose to Get all the list of AddressBook Data
     */
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    /**
     * @Purpose getting AddressBookData by its ID
     */

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookRepository
                .findById(personId)
                .orElseThrow(() -> new AddressBookException("Person with perssonId " + personId + " doesnot exists"));
    }

    /**
     * @Purpose to creating contacts details in AddressBook Data
     */

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("AddressBookData: " + addressBookData.toString());
        return addressBookRepository.save(addressBookData);
    }

    /**
     * @Purpose to Update AddressBook Data
     */
    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.updateAddressBookdata(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }
    /**
     * @Purpose to delete contacts from AddressBook Data
     */
    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookRepository.delete(addressBookData);
    }

    /**
     * @Purpose to get AddressBook data by city
     */
    @Override
    public List<AddressBookData> getAddressBookByCity(String city) {
        return addressBookRepository.findAllByCity(city);
    }
    /**
     * @Purpose Sorting AddressBook data by its City
     */
    @Override
    public List<AddressBookData> sortAddressBookByCity() {
        return addressBookRepository.SortByCity();
    }
    /**
     * @Purpose to get AddressBook data by State
     */
    @Override
    public List<AddressBookData> getAddressBookByState(String state) {
        return addressBookRepository.findAllByState(state);
    }
    /**
     * @Purpose Sorting AddressBook data by its State
     */
    @Override
    public List<AddressBookData> sortAddressBookByState() {
        return addressBookRepository.sortByState();
    }
    /**
     * @Purpose to get AddressBook data by Zip
     */
    @Override
    public List<AddressBookData> getAddressBookByZip(String zip) {
        return addressBookRepository.findAllByZip(zip);
    }
    /**
     * @Purpose Sorting AddressBook data by its Zip
     */
    @Override
    public List<AddressBookData> sortAddressBookByZip() {
        return addressBookRepository.sortByZip();
    }
    /**
     * @Purpose Sorting AddressBook data by its Name
     */
    @Override
    public List<AddressBookData> sortAddressBookByName() {
        return addressBookRepository.sortByName();
    }
}


















