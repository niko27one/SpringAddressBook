package com.example.SpringAddressBook.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
@Getter
@Setter
@Builder
public class Person {

  @Id
  @Column(name = "person_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDateTime dob;
  private String mobileNo;
  private String address;


  @OneToOne( cascade= CascadeType.ALL , mappedBy = "person" )
  private Registration registration;

}
