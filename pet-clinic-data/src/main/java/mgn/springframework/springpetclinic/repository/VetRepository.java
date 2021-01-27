package mgn.springframework.springpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import mgn.springframework.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
