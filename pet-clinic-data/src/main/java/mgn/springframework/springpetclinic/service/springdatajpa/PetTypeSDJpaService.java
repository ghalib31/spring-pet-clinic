package mgn.springframework.springpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.PetType;
import mgn.springframework.springpetclinic.repository.PetTypeRepository;
import mgn.springframework.springpetclinic.service.PetTypeService;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class PetTypeSDJpaService implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  @Override
  public PetType findById(final Long id) {
    return petTypeRepository.findById(id).orElse(null);
  }

  @Override
  public PetType save(final PetType petType) {
    return petTypeRepository.save(petType);
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public void delete(final PetType petType) {
    petTypeRepository.delete(petType);
  }

  @Override
  public void deleteById(final Long id) {
    petTypeRepository.deleteById(id);
  }
}
