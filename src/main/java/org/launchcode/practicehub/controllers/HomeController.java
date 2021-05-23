package org.launchcode.practicehub.controllers;

import org.launchcode.practicehub.data.PlayerRepository;
import org.launchcode.practicehub.data.PracticeRepository;
import org.launchcode.practicehub.data.UserRepository;
import org.launchcode.practicehub.models.Player;
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

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "My Dashboard");
        model.addAttribute(new Practice());
        return "index";
    }

    @PostMapping
    public String processAddPracticeForm(@ModelAttribute Practice newPractice, Model model) {
        practiceRepository.save(newPractice);
        return "practices";
    }

    @GetMapping("practices")
    public String displayAllPractices(Model model) {
        model.addAttribute("title", "All Practices");
        model.addAttribute("practices", practiceRepository.findAll());
        return "practices";
    }

    @GetMapping("name")
    public String setSkaterName(Model model) {
        model.addAttribute("title", "Please enter your skater name.");
        model.addAttribute(new Player());
        return "name";
    }

    @PostMapping("name")
    public String processSetSkaterNameForm(@ModelAttribute Player newPlayer, Model model) {
        playerRepository.save(newPlayer);
        return "index";
    }

}
