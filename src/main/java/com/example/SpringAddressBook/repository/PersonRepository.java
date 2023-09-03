package com.example.SpringAddressBook.repository;

import com.example.SpringAddressBook.entity.Person;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
  @Override
  Optional<Person> findById(Long aLong);
}
