package nl.qitter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qitter.domain.Gebruiker;
import nl.qitter.domain.Post;
import nl.qitter.repositories.GebruikerRepository;

@Service
@Transactional
public class GebruikerService {

	@Autowired
	GebruikerRepository gebruikerRepository;
	
	public Gebruiker saveGebruiker(Gebruiker gebruiker){
		if(gebruiker.getPosts()!=null) {
		for(Post post: gebruiker.getPosts()) {
		System.out.println(post.getTekst());
		}
		}
		return gebruikerRepository.save(gebruiker);
	}
	
	public void deleteGebruikerById(long id) {
		gebruikerRepository.deleteById(id);
	}
	
	public Iterable<Gebruiker> findAlleGebruikers(){
		return gebruikerRepository.findAll();
	}
	
	public Optional<Gebruiker> findGebruikerById(long id) {
     	return gebruikerRepository.findById(id);
	}
}
