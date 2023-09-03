package com.example.SpringAddressBook.dto;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersonRequest {
  private String firstName;
  private String lastName;
  private LocalDateTime dob;
  private String mobileNo;
  private String address;
  private String email;
}



