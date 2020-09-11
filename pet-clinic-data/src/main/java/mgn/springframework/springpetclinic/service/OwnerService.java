package mgn.springframework.springpetclinic.service;

import mgn.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

}
