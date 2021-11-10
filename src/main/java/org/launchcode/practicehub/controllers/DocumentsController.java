package org.launchcode.practicehub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentsController {

    @GetMapping("documents")
    public String displayDocumentsLinks(Model model) {

    model.addAttribute("title", "Documents");
        return "documents";

    }

}


