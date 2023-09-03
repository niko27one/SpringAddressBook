package com.example.SpringAddressBook.service;

import com.example.SpringAddressBook.dto.PersonRequest;
import com.example.SpringAddressBook.exceptions.PersonNotFoundException;

public interface AddressBookServices {

  void register(PersonRequest personRequest) throws Exception;

  void changePersonMobileNumber(Long personId,
      PersonRequest personRequest) throws PersonNotFoundException;

  void changePersonAddress(Long personId, PersonRequest personRequest) throws PersonNotFoundException;
}
