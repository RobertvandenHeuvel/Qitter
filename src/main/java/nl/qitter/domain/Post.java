package nl.qitter.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("posts")
	@OneToMany (fetch = FetchType.EAGER)
	private Set<Gebruiker> gebruikersMetToegang;
	
//	@JsonIgnoreProperties("posts")
//	@OneToMany (mappedBy = "reacties", fetch = FetchType.EAGER)
//	private Set<Post> reacties;
	
	private PostSoort postSoort;
	private String tekst;
	private LocalDateTime aanmaakDatum;
	
	@JsonIgnoreProperties("posts")
	@OneToOne (fetch = FetchType.EAGER)
	private Gebruiker gebruiker;
	
// Getters en Setters
	
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
//	public Set<Post> getPosts() {
//		return reacties;
//	}
//	public void setPosts(Set<Post> posts) {
//		this.reacties = posts;
//	}
	public PostSoort getPostSoort() {
		return postSoort;
	}
	public void setPostSoort(PostSoort postSoort) {
		this.postSoort = postSoort;
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
