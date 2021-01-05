package ua.roman.flats.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.roman.flats.domain.Address;
import ua.roman.flats.domain.name.NameCity;
import ua.roman.flats.domain.name.NameVoivodeship;
import ua.roman.flats.repositories.name.NameCityRepository;
import ua.roman.flats.repositories.name.NameDistrickRepository;
import ua.roman.flats.repositories.name.NameVoivodeshipRepository;
import ua.roman.flats.repositories.type.AddressRepository;

import java.util.Iterator;
import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    public final NameVoivodeshipRepository nameVoivodeshipRepository;
    public final NameCityRepository nameCityRepository;
    public final NameDistrickRepository nameDistrickRepository;
    public final AddressRepository addressRepository;

    public BootStrapData(NameVoivodeshipRepository nameVoivodeshipRepository, NameCityRepository nameCityRepository, NameDistrickRepository nameDistrickRepository, AddressRepository addressRepository) {
        this.nameVoivodeshipRepository = nameVoivodeshipRepository;
        this.nameCityRepository = nameCityRepository;
        this.nameDistrickRepository = nameDistrickRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) {
        runBigOne();
    }


    private void runBigOne() {
        System.out.println("---bootstrap start---");

//        Optional<NameVoivodeship> voivodeship = nameVoivodeshipRepository.findById((int) (Math.random()*16+1));
//        Optional<NameCity> city = nameCityRepository.findById((int) (Math.random()*16+1));
//
//        Address address = new Address("Długa", 81, 12, 3000);
//        address.setNameCity(city.get());
//        address.setNameVoivodeship(voivodeship.get());
//
//        addressRepository.save(address);
//
//        System.out.println("---address saved---");

        Iterator<Address> all = addressRepository.findAll().iterator();
        Iterator<Address> byStreetName = addressRepository.findByStreetIgnoreCase("długa").iterator();
        Iterator<Address> byProperty = addressRepository.findByNameCityName("Rzeszów").iterator();

        System.out.println("---addresses retrieved---");

        while(all.hasNext()){
            System.out.println(all.next());
        }

        while(byProperty.hasNext()){
            System.out.println(byProperty.next());
        }

        System.out.println("---bootstrap end---");
    }
}
