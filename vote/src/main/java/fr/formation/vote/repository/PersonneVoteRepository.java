package fr.formation.vote.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.formation.vote.entity.PersonneVote;

@Repository
public class PersonneVoteRepository {
    final String SELECT = "SELECT * FROM personneVote";
    final String INSERT = "INSERT INTO personneVote(nomVotant,dtNaissance,nomCandidat) VALUES(:nomVotant,:dtNaissance,:nomCandidat)";
    final String SELECT_BY_NOMVOTANT = "SELECT * FROM personneVote WHERE nomVotant=:nomVotant";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    RowMapper<PersonneVote> mapper = (rs, i) -> new PersonneVote(rs.getString("nomVotant"), rs.getDate("dtNaissance").toLocalDate(),
            rs.getString("nomCandidat"));

    public void insert(PersonneVote personneVote) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(personneVote);
        namedParameterJdbcTemplate.update(INSERT, namedParameters, keyHolder);
        personneVote.setIdPersonneVote(keyHolder.getKey().intValue());
    }


    public List<PersonneVote> getAll() {
        return jdbcTemplate.query(SELECT, mapper);

    }
    public PersonneVote findByNomVotant(String nomVotant) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nomVotant", nomVotant);
        PersonneVote personneVote = namedParameterJdbcTemplate.queryForObject(SELECT_BY_NOMVOTANT,namedParameters, new BeanPropertyRowMapper<>(PersonneVote.class));
        return personneVote;
    }
}

