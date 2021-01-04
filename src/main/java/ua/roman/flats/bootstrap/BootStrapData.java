package ua.roman.flats.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.roman.flats.domain.Building;
import ua.roman.flats.domain.name.NameCity;
import ua.roman.flats.domain.type.TypeConstruction;
import ua.roman.flats.repositories.BuildingRepository;
import ua.roman.flats.repositories.type.TypeConstructionRepository;

import java.util.Iterator;
import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BuildingRepository buildingRepository;
    private final TypeConstructionRepository typeConstructionRepository;

    public BootStrapData(BuildingRepository buildingRepository, TypeConstructionRepository typeConstructionRepository) {
        this.buildingRepository = buildingRepository;
        this.typeConstructionRepository = typeConstructionRepository;
    }

    @Override
    public void run(String... args) {
        runBigOne();
    }


    private void runBigOne() {
        System.out.println("---bootstrap start---");

        Optional<TypeConstruction> construction = typeConstructionRepository.findById(1);
        Building building = new Building();
        building.setFloor(3);
        building.setLift(true);
        building.setNumberOfFloors(15);
        construction.ifPresent(building::setTypeConstruction);

        buildingRepository.save(building);

        System.out.println("building added to database");

        for (Building value : buildingRepository.findAll()) {
            System.out.println(value);
        }

        System.out.println("---bootstrap end---");
    }
}
