package mgn.springframework.springpetclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
  void findOwners() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/findOwners"));
    verifyNoInteractions(ownerService);
  }

  @Test
  void showOwner() throws Exception {
    when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/1"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownerDetails"))
        .andExpect(model().attribute("owner", notNullValue()));
  }

  @Test
  void processFindFormReturnMany() throws Exception {
    when(ownerService.findAllByLastNameLike(anyString()))
        .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
            Owner.builder().id(2l).build()));

    mockMvc.perform(get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownersList"))
        .andExpect(model().attribute("selections", hasSize(2)));
  }

  @Test
  void processFindFormReturnOne() throws Exception {
    when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1l).build()));

    mockMvc.perform(get("/owners"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"));
  }

  @Test
  void processFindFormEmptyReturnMany() throws Exception {
    when(ownerService.findAllByLastNameLike(anyString()))
        .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
            Owner.builder().id(2l).build()));

    mockMvc.perform(get("/owners")
        .param("lastName", ""))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownersList"))
        .andExpect(model().attribute("selections", hasSize(2)));
  }

  @Test
  void initCreationForm() throws Exception {
    mockMvc.perform(get("/owners/new"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(model().attributeExists("owner"));

    verifyNoInteractions(ownerService);
  }

  @Test
  void processCreationForm() throws Exception {
    when(ownerService.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1l).build());

    mockMvc.perform(post("/owners/new"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"))
        .andExpect(model().attributeExists("owner"));

    verify(ownerService).save(ArgumentMatchers.any());
  }

  @Test
  void initUpdateOwnerForm() throws Exception {
    when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

    mockMvc.perform(get("/owners/1/edit"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(model().attributeExists("owner"));

    verify(ownerService, times(1)).findById(anyLong());
  }

  @Test
  void processUpdateOwnerForm() throws Exception {
    when(ownerService.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1l).build());

    mockMvc.perform(post("/owners/1/edit"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"))
        .andExpect(model().attributeExists("owner"));

    verify(ownerService).save(ArgumentMatchers.any());
  }

}