package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import mgn.springframework.springpetclinic.model.Speciality;
import mgn.springframework.springpetclinic.service.SpecialitiesService;

@Service
public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

  @Override
  public Speciality findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Speciality save(final Speciality speciality) {
    return super.save(speciality);
  }

  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(final Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(final Speciality speciality) {
    super.delete(speciality);
  }
}
