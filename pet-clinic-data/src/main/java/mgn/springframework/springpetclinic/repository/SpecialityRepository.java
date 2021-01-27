package mgn.springframework.springpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
