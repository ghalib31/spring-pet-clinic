package mgn.springframework.springpetclinic.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mgn.springframework.springpetclinic.model.Owner;

class OwnerMapServiceTest {

  private OwnerMapService ownerMapService;
  private Long ownerId = 1L;

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
    ownerMapService.save(Owner.builder().id(ownerId).lastName("Cruise").build());
  }

  @Test
  void findById() {
    Owner owner = ownerMapService.findById(1L);
    assertEquals(1L, owner.getId());
  }

  @Test
  void saveExistingId() {
    Long existingOwnerId = 2L;
    Owner owner = ownerMapService.save(Owner.builder().id(existingOwnerId).build());
    assertEquals(2L, owner.getId());
  }

  @Test
  void saveNewId() {
    Owner owner = ownerMapService.save(Owner.builder().build());
    assertNotNull(owner);
    assertNotNull(owner.getId());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = ownerMapService.findAll();
    assertEquals(1, ownerSet.size());
  }

  @Test
  void deleteById() {
    ownerMapService.deleteById(ownerId);
    Owner owner = ownerMapService.findById(ownerId);
    assertNull(owner);
  }

  @Test
  void delete() {
    Owner beforeDelete = ownerMapService.findById(ownerId);
    assertNotNull(beforeDelete);
    ownerMapService.delete(beforeDelete);
    Owner afterDelete = ownerMapService.findById(ownerId);
    assertNull(afterDelete);
  }

  @Test
  void findByLastName() {
    Owner owner = ownerMapService.findByLastName("Cruise");
    assertEquals(1L, owner.getId());
  }
}