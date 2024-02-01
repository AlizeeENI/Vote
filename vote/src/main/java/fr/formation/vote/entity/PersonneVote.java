package fr.formation.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneVote {
    private Integer idPersonneVote;
    private String nomVotant;
    private LocalDate dtNaissance;
    private String nomCandidat;
    private String mdp;


    public PersonneVote(String nomVotant, LocalDate dtNaissance, String nomCandidat) {
        this.nomVotant = nomVotant;
        this.dtNaissance = dtNaissance;
        this.nomCandidat = nomCandidat;
    }

    public PersonneVote(String nomVotant, String mdp, String nomCandidat, LocalDate dtNaissance) {
        this.mdp = mdp;
        this.nomVotant = nomVotant;
        this.nomCandidat = nomCandidat;
        this.dtNaissance = dtNaissance;
    }

}
