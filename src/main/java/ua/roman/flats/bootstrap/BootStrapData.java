package ua.roman.flats.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.roman.flats.domain.*;
import ua.roman.flats.repositories.AdvertisementRepository;
import ua.roman.flats.repositories.BuildingRepository;
import ua.roman.flats.repositories.FlatRepository;
import ua.roman.flats.repositories.LandlordRepository;
import ua.roman.flats.repositories.name.NameCityRepository;
import ua.roman.flats.repositories.name.NameDistrickRepository;
import ua.roman.flats.repositories.name.NameVoivodeshipRepository;
import ua.roman.flats.repositories.type.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.NoSuchElementException;

@Component
public class BootStrapData implements CommandLineRunner {

    public final NameVoivodeshipRepository nameVoivodeshipRepository;
    public final NameCityRepository nameCityRepository;
    public final NameDistrickRepository nameDistrickRepository;
    public final TypeConstructionRepository typeConstructionRepository;
    public final TypeHeatingRepository typeHeatingRepository;
    public final TypeLandlordRepository typeLandlordRepository;
    public final TypeMarketRepository typeMarketRepository;
    public final AddressRepository addressRepository;
    public final AdvertisementRepository advertisementRepository;
    public final BuildingRepository buildingRepository;
    public final FlatRepository flatRepository;
    public final LandlordRepository landlordRepository;

    public BootStrapData(NameVoivodeshipRepository nameVoivodeshipRepository, NameCityRepository nameCityRepository, NameDistrickRepository nameDistrickRepository, TypeConstructionRepository typeConstructionRepository, TypeHeatingRepository typeHeatingRepository, TypeLandlordRepository typeLandlordRepository, TypeMarketRepository typeMarketRepository, AddressRepository addressRepository, AdvertisementRepository advertisementRepository, BuildingRepository buildingRepository, FlatRepository flatRepository, LandlordRepository landlordRepository) {
        this.nameVoivodeshipRepository = nameVoivodeshipRepository;
        this.nameCityRepository = nameCityRepository;
        this.nameDistrickRepository = nameDistrickRepository;
        this.typeConstructionRepository = typeConstructionRepository;
        this.typeHeatingRepository = typeHeatingRepository;
        this.typeLandlordRepository = typeLandlordRepository;
        this.typeMarketRepository = typeMarketRepository;
        this.addressRepository = addressRepository;
        this.advertisementRepository = advertisementRepository;
        this.buildingRepository = buildingRepository;
        this.flatRepository = flatRepository;
        this.landlordRepository = landlordRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("---Bootstrap starting---");
        try {
        Advertisement advertisement = new Advertisement();

        final Address address = getAddress();
        final Building building = getBuilding();
        final Flat flat = getFlat();
        final Landlord landlord = getLandlord();

        advertisement.setAddress(address);
        advertisement.setBuilding(building);
        advertisement.setFlat(flat);
        advertisement.setLandlord(landlord);
        advertisement.setNumber("123abc");
        advertisement.setCreationTime(java.sql.Date.valueOf("2020-01-03"));
        advertisement.setTimestampAddingToDatabase(new Date(System.currentTimeMillis()));

        addressRepository.save(address);
//        buildingRepository.save(building);
//        flatRepository.save(flat);
//        landlordRepository.save(landlord);
//        advertisementRepository.save(advertisement);

        System.out.println("---Advertisement added---");

        } catch (NoSuchElementException exception) {
            System.out.println("No such element as: " + exception.getMessage());
        } finally {
            System.out.println("---Bootstrap finished---");
        }
    }

    private Address getAddress() throws NoSuchElementException {
        return new Address("Górczewska", 13, 51, 5500, nameVoivodeshipRepository.findById(4).orElseThrow(), nameCityRepository.findById(4).orElseThrow(), nameDistrickRepository.findById(4).orElseThrow());
    }

    private Building getBuilding() throws NoSuchElementException {
        return new Building(true, 15, 5, 1991, typeConstructionRepository.findById(1).orElseThrow());
    }

    private Flat getFlat() throws NoSuchElementException {
        Flat flat = new Flat();
        flat.setPrice(new BigDecimal(500000));
        flat.setTypeMarket(typeMarketRepository.findById(1).orElseThrow());
        flat.setTypeHeating(typeHeatingRepository.findById(1).orElseThrow());
        flat.setBalcony(true);
        flat.setKitchenette(false);
        flat.setFurnished(true);
        flat.setAirCondition(false);
        flat.setToRenovation(false);
        flat.setArea(55);
        flat.setNumberOfRooms(3);
        flat.setRent(new BigDecimal(640));
        return flat;
    }

    private Landlord getLandlord() {
        Landlord landlord = new Landlord();
        landlord.setTypeLandlord(typeLandlordRepository.findById(1).orElseThrow());
        landlord.setTelephone("123321123");
        landlord.setEmailAddress("raz@dwa.trzy");
        landlord.setFirstName("Jan");
        landlord.setLastName("Brzechwa");
        return landlord;
    }
}
