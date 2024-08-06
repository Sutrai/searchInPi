package org.example.pifinder.controllers;

import org.example.pifinder.services.PiFinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
public class MainController {

    private PiFinder piFinder;

    public MainController(PiFinder piFinder) {
        this.piFinder = piFinder;
    }

    @GetMapping("")
    public String start(){
        return "first";
    }

    @GetMapping("pi")
    public String search(@RequestParam("name") String name, Model model) throws IOException {
        model.addAttribute("name", piFinder.piSearch(name));
        return "first";
    }

}
