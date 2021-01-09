package ua.roman.flats.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.roman.flats.repositories.type.AddressRepository;

@Controller
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping("/addresses")
    public String getAddresses(Model model){

        model.addAttribute("addresses", addressRepository.findAll());

        return "addresses/list";
    }
}
