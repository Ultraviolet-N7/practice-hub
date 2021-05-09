package org.launchcode.practicehub.controllers;

import org.launchcode.practicehub.data.PracticeRepository;
import org.launchcode.practicehub.models.Practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    private PracticeRepository practiceRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "My Dashboard");
        model.addAttribute(new Practice());
        return "index";
    }

    @PostMapping
    public String processAddPracticeForm(@ModelAttribute Practice newPractice) {
        practiceRepository.save(newPractice);
        return "practices";
    }

    @GetMapping("practices")
    public String listAllPractices(Model model) {
        model.addAttribute("title", "All Practices");
        model.addAttribute("practices", practiceRepository.findAll());
        return "practices";
    }

}
