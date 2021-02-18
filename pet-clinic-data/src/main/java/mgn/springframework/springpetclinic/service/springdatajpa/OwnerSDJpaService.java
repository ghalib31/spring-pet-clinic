package mgn.springframework.springpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.repository.OwnerRepository;
import mgn.springframework.springpetclinic.service.OwnerService;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class OwnerSDJpaService implements OwnerService {
  private final OwnerRepository ownerRepository;

  @Override
  public Owner findByLastName(final String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  public Owner findById(final Long id) {
    return ownerRepository.findById(id).orElse(null);
  }

  @Override
  public Owner save(final Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public void delete(final Owner owner) {
    ownerRepository.delete(owner);
  }

  @Override
  public void deleteById(final Long id) {
    ownerRepository.deleteById(id);
  }
}
