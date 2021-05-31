package org.launchcode.practicehub.controllers;

import org.launchcode.practicehub.data.PlayerRepository;
import org.launchcode.practicehub.data.PracticeRepository;
import org.launchcode.practicehub.data.UserRepository;
import org.launchcode.practicehub.models.Player;
import org.launchcode.practicehub.models.Practice;
import org.launchcode.practicehub.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    @GetMapping
    public String displayPlayerDashboard(Model model, HttpServletRequest request,
                                         HttpSession session) {
        //Integer userId = (Integer) session.getAttribute(userSessionKey);
        User user = getUserFromSession(request.getSession());
        model.addAttribute("title", "My Dashboard");
        // call to practice cred getter method - map it to thymeleaf variable
        model.addAttribute("skater", user.getSkaterName());
        model.addAttribute(new Practice());

        return "index";
    }


    @PostMapping
    public String processAddPracticeForm(@ModelAttribute Practice newPractice, Model model) {
//        public double getCurrentMonthTotal(){
//            double total = 0;
//            LocalDate currentDate = LocalDate.now();
//            Month currentMonth = currentDate.getMonth();
//            for (Practice practice : practices) {
//                if (practice.getDate().getMonth() == currentMonth) {
//                    total += practice.getNumCredits();
//                }
//            }
//        }
        practiceRepository.save(newPractice);
        return "redirect:";
    }

    @GetMapping("practices")
    public String displayAllPractices(Model model) {
        model.addAttribute("title", "All Practices");
        model.addAttribute("practices", practiceRepository.findAll());
        return "practices";
    }

//    @GetMapping("name")
//    public String setSkaterName(Model model) {
//        model.addAttribute("title", "Please enter your skater name.");
//        model.addAttribute(new Player());
//        return "name";
//    }
//
//    @PostMapping("name")
//    public String processSetSkaterNameForm(@ModelAttribute Player newPlayer, Model model) {
//
//        playerRepository.save(newPlayer);
//        return "index";
//    }

}
