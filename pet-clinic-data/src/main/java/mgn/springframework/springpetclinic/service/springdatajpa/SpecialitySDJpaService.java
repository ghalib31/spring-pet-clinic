package mgn.springframework.springpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Speciality;
import mgn.springframework.springpetclinic.repository.SpecialityRepository;
import mgn.springframework.springpetclinic.service.SpecialityService;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class SpecialitySDJpaService implements SpecialityService {

  private final SpecialityRepository specialityRepository;

  @Override
  public Speciality findById(final Long id) {
    return specialityRepository.findById(id).orElse(null);
  }

  @Override
  public Speciality save(final Speciality speciality) {
    return specialityRepository.save(speciality);
  }

  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> specialities = new HashSet<>();
    specialityRepository.findAll().forEach(specialities::add);
    return specialities;
  }

  @Override
  public void delete(final Speciality speciality) {
    specialityRepository.delete(speciality);
  }

  @Override
  public void deleteById(final Long id) {
    specialityRepository.deleteById(id);
  }
}
