package nl.qitter.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qitter.domain.Post;

@Component
public interface PostRepository extends CrudRepository<Post, Long>{

}
