package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.service.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
  @Override
  public Vet findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(final Vet vet) {
    return super.save(vet);
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
