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
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Groep> groepen;
	
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

	public Set<Groep> getGroepen() {
		return groepen;
	}

	public void setGroepen(Set<Groep> groepen) {
		this.groepen = groepen;
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
}