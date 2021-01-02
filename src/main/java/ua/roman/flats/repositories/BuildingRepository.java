package ua.roman.flats.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.flats.domain.Building;

public interface BuildingRepository extends CrudRepository<Building, Long> {
}
