package ua.roman.beta.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.roman.beta.domain.Advertisement;
import ua.roman.beta.domain.Flat;
import ua.roman.beta.repositories.AdvertisementRepository;
import ua.roman.beta.repositories.FlatRepository;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final FlatRepository flatRepository;
    private final AdvertisementRepository advertisementRepository;

    public BootStrapData(FlatRepository flatRepository, AdvertisementRepository advertisementRepository) {
        this.flatRepository = flatRepository;
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public void run(String... args) {
        runBigOne();
    }


    private void runBigOne() {
        System.out.println("---bootstrap start---");
        Flat flat = new Flat(2, new BigDecimal(2), 2, "b");
        Advertisement advertisement = new Advertisement("123abc", new Date());
        Advertisement advertisement2 = new Advertisement("456abc", new Date());
        Advertisement advertisement3 = new Advertisement("789abc", new Date());

        flat.getAdvertisements().add(advertisement);
        flat.getAdvertisements().add(advertisement3);

        flatRepository.save(flat);
        advertisementRepository.save(advertisement2);

        System.out.println("Number of adverts about this flat: " + flat.getAdvertisements().size());
        for(Advertisement a : flat.getAdvertisements()){
            System.out.println(a.getNumber());
        }
        System.out.println("number of flats: " + flatRepository.count());
        System.out.println("number of advertisements: " + advertisementRepository.count());
        System.out.println("---bootstrap end---");
    }
}
