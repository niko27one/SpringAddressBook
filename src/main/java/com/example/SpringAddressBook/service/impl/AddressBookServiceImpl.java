package com.example.SpringAddressBook.service.impl;
import com.example.SpringAddressBook.dto.PersonRequest;
import com.example.SpringAddressBook.entity.Person;
import com.example.SpringAddressBook.entity.Registration;
import com.example.SpringAddressBook.exceptions.PersonAlreadyExistException;
import com.example.SpringAddressBook.exceptions.PersonNotFoundException;
import com.example.SpringAddressBook.repository.PersonRepository;
import com.example.SpringAddressBook.repository.RegistrationRepository;
import com.example.SpringAddressBook.service.AddressBookServices;
import com.example.SpringAddressBook.validation.impl.RegisterValidation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressBookServiceImpl implements AddressBookServices {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  RegistrationRepository registrationRepository;

  @Autowired
  RegisterValidation registerValidation;

  @Override
  public void register(PersonRequest personRequest) throws Exception {
    if(registerValidation.checkIfExist(personRequest.getEmail())){
      throw new PersonAlreadyExistException("Person already in the AddressBook");
    }
    Person person = Person.builder().firstName(personRequest.getFirstName())
        .lastName(personRequest.getLastName())
        .dob(personRequest.getDob())
        .mobileNo(personRequest.getMobileNo())
        .address(personRequest.getAddress()).build();
    Registration registration =new Registration();
    registration.setPerson(person);
    registration.setEmail(personRequest.getEmail());
    person.setRegistration(registration);
    personRepository.save(person);
  }

  @Override
  public void changePersonMobileNumber(Long personId, PersonRequest personRequest) throws PersonNotFoundException {
    Optional<Person> person = personRepository.findById(personId);
    if(person.isPresent()){
      person.get().setMobileNo(personRequest.getMobileNo());
      personRepository.save(person.get());
    }else{
      throw new PersonNotFoundException("Person not found");
    }
  }

  @Override
  public void changePersonAddress(Long personId, PersonRequest personRequest) throws PersonNotFoundException{
    Optional<Person> person = personRepository.findById(personId);
    if(person.isPresent()){
      person.get().setAddress(personRequest.getAddress());
      personRepository.save(person.get());
    }else{
      throw new PersonNotFoundException("Person not found");
    }
  }
}
