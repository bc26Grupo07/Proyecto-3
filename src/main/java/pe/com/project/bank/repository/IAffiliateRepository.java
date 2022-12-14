package pe.com.project.bank.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.project.bank.model.Affiliate;
import reactor.core.publisher.Mono;

@Repository
public interface IAffiliateRepository extends ReactiveCrudRepository<Affiliate, Integer> {
    @Query("{'id': ?0}")
    Mono<Void> delete(Integer id);
}
