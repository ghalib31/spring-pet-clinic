package mgn.springframework.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Override
  public String toString() {
    return name;
  }

  @Builder
  public PetType(final String name, final Long id) {
    super(id);
    this.name = name;
  }
}
