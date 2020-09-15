package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.service.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

  @Override
  public Owner findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(final Owner owner) {
    return super.save(owner.getId(), owner);
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
}
