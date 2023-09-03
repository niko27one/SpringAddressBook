package com.example.SpringAddressBook.validation.impl;

import com.example.SpringAddressBook.entity.Registration;
import com.example.SpringAddressBook.repository.RegistrationRepository;
import com.example.SpringAddressBook.validation.ValidationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidation implements ValidationService<String> {

  @Autowired
  RegistrationRepository registrationRepository;


  @Override
  public boolean checkIfExist(String email) {
    Optional<List<Registration>> registration = registrationRepository.findByEmail(email);
    if(registration.isPresent() && !registration.get().isEmpty()){
      return true;
    }
    return false;
  }


  @Override
  public boolean checkValidParameters(String arg) throws Exception {
    return false;
  }



}
