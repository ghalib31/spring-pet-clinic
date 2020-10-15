package mgn.springframework.springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mgn.springframework.springpetclinic.service.OwnerService;

@Controller
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(final OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @GetMapping("/owners")
  public String listOwners(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }

  @GetMapping("/owners/find")
  public String notImplemented() {
    return "notImplemented";
  }
}
