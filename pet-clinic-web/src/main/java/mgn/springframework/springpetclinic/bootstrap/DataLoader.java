package mgn.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mgn.springframework.springpetclinic.model.Owner;
import mgn.springframework.springpetclinic.model.Pet;
import mgn.springframework.springpetclinic.model.PetType;
import mgn.springframework.springpetclinic.model.Speciality;
import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.service.OwnerService;
import mgn.springframework.springpetclinic.service.PetTypeService;
import mgn.springframework.springpetclinic.service.SpecialityService;
import mgn.springframework.springpetclinic.service.VetService;

@Slf4j
@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;

  @Override
  public void run(final String... args) throws Exception {
    int count = petTypeService.findAll().size();
    if (count == 0) {
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    petTypeService.save(cat);

    Speciality radiology = new Speciality();
    radiology.setDescription("Radiology");
    final Speciality radiologySpeciality = specialityService.save(radiology);

    Speciality surgery = new Speciality();
    surgery.setDescription("Surgery");
    final Speciality surgerySpeciality = specialityService.save(surgery);

    Speciality dentistry = new Speciality();
    dentistry.setDescription("Dentistry");
    specialityService.save(dentistry);

    log.info("Loaded PetType data");

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("Adress 1");
    owner1.setCity("City 1");
    owner1.setTelephone("0987655445");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(dog);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenanne");
    owner1.setAddress("Adress 2");
    owner1.setCity("City 2");
    owner1.setTelephone("09876553442");

    Pet fionasPet = new Pet();
    fionasPet.setPetType(cat);
    fionasPet.setOwner(owner2);
    fionasPet.setBirthDate(LocalDate.now());
    fionasPet.setName("Just cat");
    owner2.getPets().add(fionasPet);

    ownerService.save(owner2);

    log.info("Loaded owner data...");

    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vet1.getSpecialities().add(radiologySpeciality);
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vet2.getSpecialities().add(surgerySpeciality);
    vetService.save(vet2);

    log.info("Loaded vet data...");
  }
}
