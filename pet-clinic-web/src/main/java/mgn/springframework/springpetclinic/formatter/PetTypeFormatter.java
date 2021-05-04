package mgn.springframework.springpetclinic.formatter;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import mgn.springframework.springpetclinic.model.PetType;
import mgn.springframework.springpetclinic.service.PetTypeService;

@Component
@AllArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {
  private final PetTypeService petTypeService;

  @Override
  public String print(PetType petType, Locale locale) {
    return petType.getName();
  }

  @Override
  public PetType parse(String text, Locale locale) throws ParseException {
    Collection<PetType> findPetTypes = petTypeService.findAll();

    for (PetType type : findPetTypes) {
      if (type.getName().equals(text)) {
        return type;
      }
    }

    throw new ParseException("type not found: " + text, 0);
  }
}
