package mgn.springframework.springpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
