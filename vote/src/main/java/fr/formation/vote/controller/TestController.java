package fr.formation.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.vote.service.PersonneVoteService;

@Controller
public class TestController {
    @Autowired
    public PersonneVoteService service;

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("personneVote",service.getAllPersonneVote());
        return "accueil";
    }

    @GetMapping("/urlvote")
    public String url1() {
        return "urlvote";
    }

    @GetMapping("/urlresultat")
    public String url2(Authentication authentication) {
        return "urlresultat";
    }


}