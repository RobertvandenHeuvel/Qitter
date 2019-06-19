package nl.qitter.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Groep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("groep")
	@ManyToMany (mappedBy = "groep", fetch = FetchType.EAGER)
	private Set<Gebruiker> gebruikers = new HashSet<Gebruiker>();

	private String groepsNaam;
	
	
//	Getters en Setters
	
	public Set<Gebruiker> getGebruikers() {
		return gebruikers;
	}
	public void setGebruikers(Set<Gebruiker> gebruikers) {
		this.gebruikers = gebruikers;
	}
	
	public void addGebruiker(Gebruiker gebruiker) {
		System.out.println("in addgebruiker van Groep " +  this.gebruikers +"" + gebruiker.getVoornaam() + "" + this.groepsNaam);
		this.gebruikers.add(gebruiker);
	}
	
	public String getGroepsNaam() {
		return groepsNaam;
	}
	public void setGroepsNaam(String groepsNaam) {
		this.groepsNaam = groepsNaam;
	}
	public long getId() {
		return id;
	}

}