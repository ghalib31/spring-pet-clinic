package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.service.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
  @Override
  public Vet findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(final Vet vet) {
    return super.save(vet.getId(), vet);
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(final Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(final Vet vet) {
    super.delete(vet);
  }
}
