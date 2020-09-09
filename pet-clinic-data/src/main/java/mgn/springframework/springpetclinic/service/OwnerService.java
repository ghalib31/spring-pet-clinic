package mgn.springframework.springpetclinic.service;

import java.util.Set;

import mgn.springframework.springpetclinic.model.Owner;

public interface OwnerService {

  Owner findByLastName(String lastName);

  Owner findById(Long id);

  Owner save(Owner owner);

  Set<Owner> findAll();
}
