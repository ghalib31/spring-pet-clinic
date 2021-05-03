package mgn.springframework.springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mgn.springframework.springpetclinic.service.OwnerService;

@Controller
@RequestMapping("owners")
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(final OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @GetMapping
  public String listOwners(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }

  @GetMapping("/find")
  public String findOwners() {
    return "notImplemented";
  }

  @GetMapping("/{ownerId}")
  public ModelAndView showOwner(@PathVariable final Long ownerId) {
    ModelAndView mav = new ModelAndView("owners/ownerDetails");
    mav.addObject(ownerService.findById(ownerId));
    return mav;
  }
}
