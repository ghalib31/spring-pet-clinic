package mgn.springframework.springpetclinic.service;

import java.util.Set;

import mgn.springframework.springpetclinic.model.Pet;

public interface PetService {

  Pet findById(Long id);

  Pet save(Pet pet);

  Set<Pet> findAll();
}
