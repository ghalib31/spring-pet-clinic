package mgn.springframework.springpetclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);

}
