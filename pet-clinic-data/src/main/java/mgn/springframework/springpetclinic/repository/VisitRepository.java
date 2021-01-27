package mgn.springframework.springpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
