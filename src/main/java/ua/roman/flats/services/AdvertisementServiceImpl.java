package ua.roman.flats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.roman.flats.domain.Advertisement;
import ua.roman.flats.repositories.AdvertisementRepository;

import java.util.Iterator;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public void addAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    @Override
    public Iterator<Advertisement> findAllAdvertisement() {
        return advertisementRepository.findAll().iterator();
    }

    public Advertisement findAdvertisement(long id) {
        return advertisementRepository.findById(id).orElseThrow();
    }

}
