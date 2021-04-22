package mgn.springframework.springpetclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.service.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
  @Mock
  OwnerService ownerService;
  @InjectMocks
  OwnerController ownerController;
  Set<Owner> ownerSet;
  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    ownerSet = new HashSet<>();
    ownerSet.add(Owner.builder().id(1L).build());
    ownerSet.add(Owner.builder().id(2L).build());
    mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
  }

  @Test
  void listOwners() throws Exception {
    when(ownerService.findAll()).thenReturn(ownerSet);
    mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", hasSize(2)));
  }

  @Test
  void findOwners() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("notImplemented"));
    verifyNoInteractions(ownerService);
  }
}