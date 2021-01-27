package mgn.springframework.springpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
