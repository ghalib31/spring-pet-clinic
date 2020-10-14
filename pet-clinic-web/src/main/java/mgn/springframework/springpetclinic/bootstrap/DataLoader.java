package mgn.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.model.Pet;
import mgn.springframework.springpetclinic.model.PetType;
import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.service.OwnerService;
import mgn.springframework.springpetclinic.service.PetTypeService;
import mgn.springframework.springpetclinic.service.VetService;

@Slf4j
@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  @Override
  public void run(final String... args) throws Exception {
    PetType dog = new PetType();
    dog.setName("Dog");
    petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    petTypeService.save(cat);

    log.info("Loaded PetType data");

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("Adress 1");
    owner1.setCity("City 1");
    owner1.setTelephone("0987655445");
    ownerService.save(owner1);

    Pet mikesPet = new Pet();
    mikesPet.setPetType(dog);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenanne");
    owner1.setAddress("Adress 2");
    owner1.setCity("City 2");
    owner1.setTelephone("09876553442");
    ownerService.save(owner2);

    Pet fionasPet = new Pet();
    fionasPet.setPetType(cat);
    fionasPet.setOwner(owner2);
    fionasPet.setBirthDate(LocalDate.now());
    fionasPet.setName("Just cat");
    owner2.getPets().add(fionasPet);

    log.info("Loaded owner data...");

    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vetService.save(vet2);

    log.info("Loaded vet data...");
  }
}
