package ua.roman.beta.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.beta.domain.Flat;

public interface FlatRepository extends CrudRepository<Flat, Long> {
}
