package com.example.SpringAddressBook.validation;

public interface ValidationService<T> {
  boolean checkIfExist(T arg) throws Exception;
  boolean checkValidParameters(T arg) throws Exception;

}
