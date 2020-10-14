package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import mgn.springframework.springpetclinic.model.Speciality;
import mgn.springframework.springpetclinic.service.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

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
