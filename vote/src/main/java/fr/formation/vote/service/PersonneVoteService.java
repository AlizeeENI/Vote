package fr.formation.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.vote.entity.PersonneVote;
import fr.formation.vote.repository.PersonneVoteRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonneVoteService {
    @Autowired
    PersonneVoteRepository repo;

    @Autowired
    PasswordEncoder encodeur;

    @Transactional
    public void addUtilisateur(PersonneVote personneVote) {
        // encodage du mot de passe
        personneVote.setMdp(encodeur.encode(personneVote.getMdp()));

        // insertion en base
        repo.insert(personneVote);
    }

    public List<PersonneVote> getAllPersonneVote() {
        return repo.getAll();
    }

}
