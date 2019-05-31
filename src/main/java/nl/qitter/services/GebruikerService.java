package nl.qitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qitter.domain.Gebruiker;
import nl.qitter.repositories.GebruikerRepository;

@Service
@Transactional
public class GebruikerService {

	@Autowired
	GebruikerRepository gebruikerRepository;
	
	public Iterable<Gebruiker> findAlleGebruikers(){
		return gebruikerRepository.findAll();
		
	}
}
