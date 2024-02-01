package fr.formation.vote;

import fr.formation.vote.entity.PersonneVote;
import fr.formation.vote.service.PersonneVoteService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class VoteApplication {

    @Autowired
    public PersonneVoteService service;


    @PostConstruct
    public void init() {
        service.addUtilisateur(new PersonneVote(1,"Jessy", LocalDate.of(1999,11,5),"Jessy","Jessy"));
        service.addUtilisateur(new PersonneVote(2,"Jeffrey",LocalDate.of(2003,11,5),"Jeffrey","Jeffrey"));
        service.addUtilisateur(new PersonneVote(3,"Jean",LocalDate.of(2005,11,5),"Jeffrey","Jean"));
        service.getAllPersonneVote().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(VoteApplication.class, args);
    }


}
