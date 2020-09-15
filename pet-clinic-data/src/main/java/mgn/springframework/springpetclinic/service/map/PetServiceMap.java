package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import mgn.springframework.springpetclinic.model.Pet;
import mgn.springframework.springpetclinic.service.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
  @Override
  public Pet findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Pet save(final Pet pet) {
    return super.save(pet.getId(), pet);
  }

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(final Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(final Pet pet) {
    super.delete(pet);
  }
}
