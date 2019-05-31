package nl.qitter.services;

import java.util.Optional;

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
	
	public Groep save(Groep groep) {
     	return groepRepository.save(groep);
	}
	public void deleteById(Long id) {
		groepRepository.deleteById(id);
	}
	public Iterable<Groep> findAll() {
     	return groepRepository.findAll();
	}
	public Optional<Groep> findById(long id) {
     	return groepRepository.findById(id);
	}


}
