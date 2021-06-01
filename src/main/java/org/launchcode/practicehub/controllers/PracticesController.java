package org.launchcode.practicehub.controllers;

import org.launchcode.practicehub.data.PracticeRepository;
import org.launchcode.practicehub.data.UserRepository;
import org.launchcode.practicehub.models.Practice;
import org.launchcode.practicehub.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class PracticesController {

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

    @GetMapping("practices")
    public String displayAllPractices(Model model) {
        model.addAttribute("title", "All Practices");
        model.addAttribute("practices", practiceRepository.findAll());
        return "practices";
    }

//    @PostMapping("practices")
//    public String displaySearchResults(Model model, @RequestParam String searchTerm) {
//        Iterable<Practice> practices;
//        practices=
//        return "search-results";
//    }


}
