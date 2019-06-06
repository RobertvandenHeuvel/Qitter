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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("posts")
	@OneToMany (fetch = FetchType.EAGER)
	private Set<Gebruiker> gebruikersToegang;
	
	@JsonIgnoreProperties("posts")
	@OneToMany (mappedBy = "posts", fetch = FetchType.EAGER)
	private Set<Post> posts;
	
	private PostSoort postSoort;
	private String tekst;
	private LocalDateTime aanmaakDatum;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Gebruiker gebruiker;
	
// Getters en Setters
	
	public Gebruiker getGebruiker() {
		return gebruiker;
	}
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	public Set<Gebruiker> getGebruikersToegang() {
		return gebruikersToegang;
	}
	public void setGebruikersToegang(Set<Gebruiker> gebruikersToegang) {
		this.gebruikersToegang = gebruikersToegang;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
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
