package ua.roman.flats.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.roman.flats.domain.name.NameCity;
import ua.roman.flats.repositories.name.NameCityRepository;

import java.util.Iterator;

@Component
public class BootStrapData implements CommandLineRunner {

    private final NameCityRepository nameCityRepository;

    public BootStrapData(NameCityRepository nameCityRepository) {
        this.nameCityRepository = nameCityRepository;
    }

    @Override
    public void run(String... args) {
        runBigOne();
    }


    private void runBigOne() {
        System.out.println("---bootstrap start---");

        for (NameCity nameCity : nameCityRepository.findAll()) {
            System.out.println(nameCity);
        }

        System.out.println("---bootstrap end---");
    }
}
