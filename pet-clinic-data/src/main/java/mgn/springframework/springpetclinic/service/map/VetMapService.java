package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.Speciality;
import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.service.SpecialityService;
import mgn.springframework.springpetclinic.service.VetService;

@AllArgsConstructor
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialityService specialityService;

  @Override
  public Vet findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(final Vet vet) {
    if (vet.getSpecialities().isEmpty()) {
      vet.getSpecialities().forEach(speciality -> {
        if (speciality.getId() == null) {
          Speciality savedSpeciality = specialityService.save(speciality);
          speciality.setId(savedSpeciality.getId());
        }
      });
    }
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
