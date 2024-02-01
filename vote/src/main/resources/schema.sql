DROP TABLE IF EXISTS personneVote;
CREATE TABLE personneVote (
                             idPersonneVote INT AUTO_INCREMENT PRIMARY KEY,
                             nomVotant VARCHAR(255),
                             nomCandidat VARCHAR(255),
                             dtNaissance DATE,
                             mdp VARCHAR(255)
);