package nl.qitter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qitter.domain.Reactie;
import nl.qitter.repositories.ReactieRepository;

@Service
@Transactional
public class ReactieService {
	
	@Autowired
	ReactieRepository reactieRepository;
	
	public Reactie save(Reactie reactie) {
		System.out.println("check in reactie save: reactieservice. De tekst van de reactie is: " + reactie.getTekst());
     	return reactieRepository.save(reactie);
	}
	public void deleteById(Long id) {
		reactieRepository.deleteById(id);
	}
	public Iterable<Reactie> findAll() {
     	return reactieRepository.findAll();
	}
	public Optional<Reactie> findById(long id) {
     	return reactieRepository.findById(id);
	}
	
}
