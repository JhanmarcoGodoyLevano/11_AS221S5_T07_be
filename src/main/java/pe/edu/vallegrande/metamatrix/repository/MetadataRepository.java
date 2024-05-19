package pe.edu.vallegrande.metamatrix.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.edu.vallegrande.metamatrix.entity.Metadata;
import reactor.core.publisher.Flux;

public interface MetadataRepository extends ReactiveCrudRepository<Metadata, Integer> {
    Flux<Metadata> findByActive(char active);
}
