package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.service.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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

  @Override
  public Owner findByLastName(final String lastName) {
    return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
  }
}
