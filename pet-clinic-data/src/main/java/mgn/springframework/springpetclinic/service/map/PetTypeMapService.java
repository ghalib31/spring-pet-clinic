package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import mgn.springframework.springpetclinic.model.PetType;
import mgn.springframework.springpetclinic.service.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
  @Override
  public PetType findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public PetType save(final PetType petType) {
    return super.save(petType);
  }

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(final Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(final PetType petType) {
    super.delete(petType);
  }
}
