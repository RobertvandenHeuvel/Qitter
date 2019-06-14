package nl.qitter.domain;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Gebruiker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String wachtwoord;
	private String bio;
	private String voornaam;
	private String achternaam;
	private String email;
	private Rol rol;
	
	@JsonIgnoreProperties("gebruikers")
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Groep> groep;
	
	@JsonIgnoreProperties("gebruiker")
	@OneToMany(mappedBy="gebruiker",fetch = FetchType.EAGER)
	private Set<Post> posts;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Groep> getGroep() {
		return groep;
	}

	public void setGroep(Set<Groep> groep) {
		this.groep = groep;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public long getId() {
		return id;
	}
	
	public void addPost(Post post) {
		this.posts.add(post);
		post.setGebruiker(this);
	}
}
