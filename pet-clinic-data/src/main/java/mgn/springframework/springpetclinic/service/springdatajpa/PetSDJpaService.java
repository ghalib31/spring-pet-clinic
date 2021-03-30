package mgn.springframework.springpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Pet;
import mgn.springframework.springpetclinic.repository.PetRepository;
import mgn.springframework.springpetclinic.service.PetService;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class PetSDJpaService implements PetService {

  private final PetRepository petRepository;

  @Override
  public Pet findById(final Long id) {
    return petRepository.findById(id).orElse(null);
  }

  @Override
  public Pet save(final Pet pet) {
    return petRepository.save(pet);
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public void delete(final Pet pet) {
    petRepository.delete(pet);
  }

  @Override
  public void deleteById(final Long id) {
    petRepository.deleteById(id);
  }
}
