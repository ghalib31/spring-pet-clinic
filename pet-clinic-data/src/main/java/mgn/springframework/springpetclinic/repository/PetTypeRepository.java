package mgn.springframework.springpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
