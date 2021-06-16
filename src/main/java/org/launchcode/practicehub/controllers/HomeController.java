package org.launchcode.practicehub.controllers;

import org.launchcode.practicehub.data.PracticeRepository;
import org.launchcode.practicehub.data.UserRepository;
import org.launchcode.practicehub.models.Practice;
import org.launchcode.practicehub.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    private UserRepository userRepository;

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
        User user = getUserFromSession(request.getSession());
        model.addAttribute("title", "My Dashboard");
        // call to practice cred getter method - loop over user's list of practices, grab cred num from each - map it
        // to thymeleaf
        model.addAttribute("skater", "Welcome back, " + user.getSkaterName() + "!");
        model.addAttribute("creditTotal", "Practice credits logged this month: " + user.setCurrentMonthTotal());
        model.addAttribute(new Practice());

        return "index";
    }

    @PostMapping
    public String processAddPracticeForm(@Valid @ModelAttribute Practice newPractice, Model model,
                                         HttpServletRequest request, Errors errors) {
        User user = getUserFromSession(request.getSession());

        if(user != null) {
            newPractice.setUser(user);
            newPractice.getUser().setSkaterName(user.getSkaterName());
        }

        if(errors.hasErrors()) {
            model.addAttribute("title", "My Dashboard");
            model.addAttribute("skater", "Welcome back, " + user.getSkaterName() + "!");
            model.addAttribute("creditTotal", "Practice credits logged this month: " + user.setCurrentMonthTotal());
            model.addAttribute("errorMsg", "Invalid submission");
            return "redirect";
        }

        practiceRepository.save(newPractice);
        return "redirect:";
    }




}
