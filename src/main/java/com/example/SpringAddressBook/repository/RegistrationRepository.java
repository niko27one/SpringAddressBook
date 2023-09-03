package com.example.SpringAddressBook.repository;
import com.example.SpringAddressBook.entity.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration,Long> {

  Optional<List<Registration>> findByEmail (String email);

}
