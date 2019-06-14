package nl.qitter.domain;

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
	private Set<Gebruiker> gebruikers;

	private String groepsNaam;
	
	
//	Getters en Setters
	
	public Set<Gebruiker> getGebruikers() {
		return gebruikers;
	}
	public void setGebruikers(Set<Gebruiker> gebruikers) {
		this.gebruikers = gebruikers;
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
