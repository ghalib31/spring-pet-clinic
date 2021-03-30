package mgn.springframework.springpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Visit;
import mgn.springframework.springpetclinic.repository.VisitRepository;
import mgn.springframework.springpetclinic.service.VisitService;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class VisitSDJpaService implements VisitService {

  private final VisitRepository visitRepository;

  @Override
  public Visit findById(final Long id) {
    return visitRepository.findById(id).orElse(null);
  }

  @Override
  public Visit save(final Visit visit) {
    return visitRepository.save(visit);
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public void delete(final Visit visit) {
    visitRepository.delete(visit);
  }

  @Override
  public void deleteById(final Long id) {
    visitRepository.deleteById(id);
  }
}
