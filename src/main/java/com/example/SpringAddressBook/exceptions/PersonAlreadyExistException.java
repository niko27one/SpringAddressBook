package com.example.SpringAddressBook.exceptions;

public class PersonAlreadyExistException extends Exception{
  public PersonAlreadyExistException(String message){
    super(message);
  }

}
