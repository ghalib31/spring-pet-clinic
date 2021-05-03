package mgn.springframework.springpetclinic.service;

import java.util.List;

import mgn.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);
}
