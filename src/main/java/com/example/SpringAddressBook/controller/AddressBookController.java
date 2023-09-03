package com.example.SpringAddressBook.controller;
import com.example.SpringAddressBook.dto.AddressBookResponse;
import com.example.SpringAddressBook.dto.PersonRequest;
import com.example.SpringAddressBook.dto.RegistrationResponse;
import com.example.SpringAddressBook.service.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/address")
public class AddressBookController {

  @Autowired
  AddressBookServices addressBookServices;

  @PostMapping("/")
  public ResponseEntity<String> register(@RequestBody PersonRequest personRequest) throws Exception{
    RegistrationResponse registrationResponse = new RegistrationResponse();
    if(personRequest.getFirstName()== null || personRequest.getFirstName().isEmpty() || personRequest.getLastName()== null || personRequest.getLastName().isEmpty() || personRequest.getAddress()==null || personRequest.getAddress().isEmpty() || personRequest.getDob()== null || personRequest.getEmail()== null || personRequest.getEmail().isEmpty() || personRequest.getMobileNo()== null || personRequest.getMobileNo().isEmpty()){
      registrationResponse.setMessage("Some fields are missing");
      return new ResponseEntity<>(registrationResponse.getMessage(), HttpStatus.BAD_REQUEST);
    }

    if(!personRequest.getFirstName().matches("[A-Za-z]*")){
      registrationResponse.setMessage("only plain characters accepted, please re-enter the name");
      return new ResponseEntity<>(registrationResponse.getMessage(), HttpStatus.BAD_REQUEST);
    }
    addressBookServices.register(personRequest);
    registrationResponse.setMessage("Person added to the Address Book");
    return new ResponseEntity<>(registrationResponse.getMessage(),HttpStatus.CREATED);
  }

  @PutMapping(value = "/{personId}/mobileNo")
  public ResponseEntity<String> mobileNo(@PathVariable(value = "customerId") final Long id,@RequestBody PersonRequest personRequest ) throws Exception{
    AddressBookResponse addressBookResponse = new AddressBookResponse();
    addressBookServices.changePersonMobileNumber(id,personRequest);
    addressBookResponse.setMessage("phone number changed");
    return new ResponseEntity<>(addressBookResponse.getMessage(),HttpStatus.OK);
  }

  @PutMapping(value = "/{personId}/address")
  public ResponseEntity<String> address(@PathVariable(value = "customerId") final Long id,@RequestBody PersonRequest personRequest ) throws Exception{
    AddressBookResponse addressBookResponse = new AddressBookResponse();
    addressBookServices.changePersonMobileNumber(id,personRequest);
    addressBookResponse.setMessage("phone number changed");
    return new ResponseEntity<>(addressBookResponse.getMessage(),HttpStatus.OK);
  }

}
