package nl.qitter.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.qitter.domain.Gebruiker;

public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>{
	Iterable<Gebruiker> findByUsernameAndWachtwoord(String username, String wachtwoord);
}
