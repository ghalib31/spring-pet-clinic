package mgn.springframework.springpetclinic.service.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.repository.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
  public static final String LAST_NAME = "LastName";
  public static final long ID = 1L;
  @InjectMocks
  OwnerSDJpaService ownerSDJpaService;
  @Mock
  OwnerRepository ownerRepository;

  @BeforeEach
  void setUp() {
  }

  @Test
  void findByLastName() {
    when(ownerRepository.findByLastName(any())).thenReturn(mockOwner());
    Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);
    assertEquals(LAST_NAME, owner.getLastName());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(mockOwner()));
    Owner owner = ownerSDJpaService.findById(ID);
    assertEquals(ID, owner.getId());
  }

  @Test
  void save() {
    when(ownerRepository.save(any(Owner.class))).thenReturn(mockOwner());
    Owner owner = ownerSDJpaService.save(mockOwner());
    assertNotNull(owner);
  }

  @Test
  void findAll() {
    Set<Owner> returnOwnerSet = new HashSet<>();
    returnOwnerSet.add(Owner.builder().id(ID).build());
    returnOwnerSet.add(Owner.builder().id(2L).build());
    when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
    final Set<Owner> ownerSet = ownerSDJpaService.findAll();
    assertEquals(returnOwnerSet.size(), ownerSet.size());
  }

  @Test
  void delete() {
    ownerSDJpaService.delete(mockOwner());
    verify(ownerRepository, times(1)).delete(any(Owner.class));
  }

  @Test
  void deleteById() {
    ownerSDJpaService.deleteById(ID);
    verify(ownerRepository, times(1)).deleteById(ID);
  }

  private Owner mockOwner() {
    return Owner.builder().lastName(LAST_NAME).id(ID).build();
  }
}