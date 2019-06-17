package nl.qitter.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import nl.qitter.domain.Reactie;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("posts")
	@OneToMany (fetch = FetchType.EAGER)
	private Set<Gebruiker> gebruikersMetToegang;
	
	@JsonIgnoreProperties("post")
	@OneToMany (mappedBy="post", fetch = FetchType.EAGER)
	private Set<Reactie> reacties;
	
	public Set<Reactie> getReacties() {
		return reacties;
	}
	public void setReacties(Set<Reactie> reacties) {
		this.reacties = reacties;
	}

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
	
	public void addReactie(Reactie reactie) {
		this.reacties.add(reactie);
		reactie.setPost(this);
	}
	
}
