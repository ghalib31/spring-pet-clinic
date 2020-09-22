package mgn.springframework.springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mgn.springframework.springpetclinic.service.VetService;

@Controller
public class VetController {

  private final VetService vetService;

  public VetController(final VetService vetService) {
    this.vetService = vetService;
  }

  @GetMapping("/vets")
  public String listVets(Model model) {
    model.addAttribute("vets", vetService.findAll());
    return "vets/index";
  }
}
