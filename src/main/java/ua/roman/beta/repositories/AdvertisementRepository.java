package ua.roman.beta.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.beta.domain.Advertisement;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
}
