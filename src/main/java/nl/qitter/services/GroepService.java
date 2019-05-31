package nl.qitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qitter.domain.Groep;
import nl.qitter.repositories.GroepRepository;

@Service
@Transactional
public class GroepService {
	
	@Autowired
	GroepRepository groepRepository;
	
	public Iterable<Groep> getAlleGroepen(){
		return groepRepository.findAll();
		
	}

}
