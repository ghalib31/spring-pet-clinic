package mgn.springframework.springpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person {
  private Set<Speciality> specialities = new HashSet<>();
}
