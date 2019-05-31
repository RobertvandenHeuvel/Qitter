package nl.qitter.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Gebruiker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	Set<Groep> groepen;
	String voorNaam;
}
