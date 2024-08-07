package org.example.pifinder.controllers;

import org.example.pifinder.services.PiFinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    private final PiFinder piFinder;

    public MainController(PiFinder piFinder) {
        this.piFinder = piFinder;
    }

    @GetMapping("")
    public String start(){
        return "first";
    }

    @GetMapping("pi")
    public String search(@RequestParam("name") String name, Model model) throws IOException {
        model.addAttribute("subString", piFinder.findIndex(name));
        return "result";
    }

}
