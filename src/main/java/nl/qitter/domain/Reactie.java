package nl.qitter.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Reactie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("posts")
	@OneToMany (fetch = FetchType.EAGER)
	private Set<Gebruiker> gebruikersMetToegang;
	
	private String tekst;
	private LocalDateTime aanmaakDatum;
	
	@JsonIgnoreProperties("posts")
	@OneToOne (fetch = FetchType.EAGER)
	private Gebruiker gebruiker;
	
	@JsonIgnoreProperties("reacties")
	@OneToOne (fetch = FetchType.EAGER)
	private Post post;
	
// Getters en Setters
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Gebruiker getGebruiker() {
		return gebruiker;
	}
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	public Set<Gebruiker> getGebruikersToegang() {
		return gebruikersMetToegang;
	}
	public void setGebruikersToegang(Set<Gebruiker> gebruikersToegang) {
		this.gebruikersMetToegang = gebruikersToegang;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public LocalDateTime getAanmaakDatum() {
		return aanmaakDatum;
	}
	public void setAanmaakDatum(LocalDateTime aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
	public long getId() {
		return id;
	}
}
