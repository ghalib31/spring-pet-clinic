package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.model.Pet;
import mgn.springframework.springpetclinic.service.OwnerService;
import mgn.springframework.springpetclinic.service.PetService;
import mgn.springframework.springpetclinic.service.PetTypeService;

@AllArgsConstructor
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

  private final PetTypeService petTypeService;
  private final PetService petService;

  @Override
  public Owner findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(final Owner owner) {
    if (owner != null) {
      if (owner.getPets() != null) {
        owner.getPets().forEach(pet -> {
          if (pet.getPetType() != null) {
            if (pet.getPetType().getId() != null) {
              pet.setPetType(petTypeService.save(pet.getPetType()));
            }
          } else {
            throw new RuntimeException("Pet type is required");
          }

          if (pet.getId() == null) {
            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
          }
        });
      }
      return super.save(owner);
    } else {
      return null;
    }
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(final Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(final Owner owner) {
    super.delete(owner);
  }

  @Override
  public Owner findByLastName(final String lastName) {
    return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
  }
}
