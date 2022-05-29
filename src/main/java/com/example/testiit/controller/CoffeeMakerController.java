package com.example.testiit.controller;

import com.example.testiit.Constant;
import com.example.testiit.model.CoffeeMaker;
import com.example.testiit.service.CoffeeMakerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "CoffeeMaker")
public class CoffeeMakerController implements Constant {

    @Autowired
    private CoffeeMakerService coffeeMakerService;

    @GetMapping(path = "/switcher")
    public @ResponseBody CoffeeMaker switchCoffeeMaker(@RequestParam int id) {
        CoffeeMaker coffeeMaker = coffeeMakerService.switcher(id);

        return coffeeMaker;
    }

    @GetMapping(path = "/add")
    public @ResponseBody CoffeeMaker addCoffeeMaker(@RequestParam String name) {
        return coffeeMakerService.add(name);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<CoffeeMaker> getAllCoffeeMaker() {
        return coffeeMakerService.getAll();
    }

    @GetMapping(path = "/getById")
    public @ResponseBody Optional<CoffeeMaker> getCoffeeMaker(@RequestParam int id){
        return coffeeMakerService.getOne(id);
    }


}
