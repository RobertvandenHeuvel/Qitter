package nl.qitter.services;

import java.util.Iterator;
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
	
	public Gebruiker findByLogin(String username, String wachtwoord) {
     	Iterable<Gebruiker> users = gebruikerRepository.findByUsernameAndWachtwoord(username, wachtwoord);
     	System.out.println("in findByLogin @GebruikerService " + username + " " + wachtwoord);
     	Gebruiker user = null;
     	Iterator<Gebruiker> x = users.iterator();
     			while(x.hasNext()) {
     				user = x.next();
     			}
     			System.out.println("in findByLogin @GebruikerService " +user.getId());
     	return user;
	}
}