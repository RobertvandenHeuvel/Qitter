package nl.qitter.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Groep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	
	@JsonIgnoreProperties("groepen")
	@ManyToMany (mappedBy = "groepen", fetch = FetchType.EAGER)
	Set<Gebruiker> gebruikers;
	String groepsNaam;
	
//	Getters en Setters
	
//	public Set<Long> getGroepsledenId() {
//		return groepsledenId;
//	}
//	public void setGroepsledenId(Set<Long> groepsledenId) {
//		this.groepsledenId = groepsledenId;
//	}
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
