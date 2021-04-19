package mgn.springframework.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class Person extends BaseEntity {

  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

  public Person(final Long id, final String firstName, final String lastName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
