package mgn.springframework.springpetclinic.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mgn.springframework.springpetclinic.model.Vet;
import mgn.springframework.springpetclinic.service.VetService;

@Controller
public class VetController {

  private final VetService vetService;

  public VetController(final VetService vetService) {
    this.vetService = vetService;
  }

  @GetMapping({ "/vets", "/vets.html" })
  public String listVets(Model model) {
    model.addAttribute("vets", vetService.findAll());
    return "vets/index";
  }

  @GetMapping("/api/vets")
  public @ResponseBody
  Set<Vet> getVetsJson() {
    return vetService.findAll();
  }
}
