package nl.qitter.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@JsonIgnoreProperties("groepen")
	@ManyToOne (fetch = FetchType.EAGER)
	Set<Gebruiker> gebruikersToegang;
	
	
	String tekst;
	LocalDateTime aanmaakDatum;
	Long restecp;
	
}
