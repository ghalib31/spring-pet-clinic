package mgn.springframework.springpetclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mgn.springframework.springpetclinic.model.Visit;
import mgn.springframework.springpetclinic.service.VisitService;

@Service
@Profile({ "default", "map" })
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

  @Override
  public Visit findById(final Long id) {
    return super.findById(id);
  }

  @Override
  public Visit save(final Visit visit) {
    return super.save(visit);
  }

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(final Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(final Visit visit) {
    super.delete(visit);
  }
}
