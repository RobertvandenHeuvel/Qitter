package nl.qitter.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qitter.domain.Groep;

@Component
public interface GroepRepository extends CrudRepository<Groep, Long>{

}
