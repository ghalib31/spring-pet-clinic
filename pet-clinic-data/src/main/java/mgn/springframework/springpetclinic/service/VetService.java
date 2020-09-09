package mgn.springframework.springpetclinic.service;

import java.util.Set;

import mgn.springframework.springpetclinic.model.Vet;

public interface VetService {

  Vet findById(Long id);

  Vet save(Vet vet);

  Set<Vet> findAll();
}
