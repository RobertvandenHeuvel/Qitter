package nl.qitter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qitter.domain.Post;
import nl.qitter.repositories.PostRepository;

@Service
@Transactional
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	
	public Post save(Post post) {
		System.out.println("check in post save: postservice. De tekst van de post is: " + post.getTekst());
     	return postRepository.save(post);
	}
	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}
	public Iterable<Post> findAll() {
     	return postRepository.findAll();
	}
	public Optional<Post> findById(long id) {
     	return postRepository.findById(id);
	}

}
