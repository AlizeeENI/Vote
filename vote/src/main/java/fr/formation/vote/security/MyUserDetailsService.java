package fr.formation.vote.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.vote.entity.PersonneVote;
import fr.formation.vote.repository.PersonneVoteRepository
        ;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonneVoteRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nomVotant) {

        PersonneVote user;
        try {
            user = userRepository.findByNomVotant(nomVotant);
            if (user == null) {
                throw new UsernameNotFoundException(nomVotant);
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException(nomVotant);
        }
        return new MyUserDetail(user);
    }

}