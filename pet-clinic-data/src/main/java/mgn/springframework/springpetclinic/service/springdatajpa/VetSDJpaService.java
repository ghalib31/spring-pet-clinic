package mgn.springframework.springpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.repository.VetRepository;
import mgn.springframework.springpetclinic.service.VetService;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class VetSDJpaService implements VetService {

  private final VetRepository vetRepository;

  @Override
  public Vet findById(final Long id) {
    return vetRepository.findById(id).orElse(null);
  }

  @Override
  public Vet save(final Vet vet) {
    return vetRepository.save(vet);
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public void delete(final Vet vet) {
    vetRepository.delete(vet);
  }

  @Override
  public void deleteById(final Long id) {
    vetRepository.deleteById(id);
  }
}
