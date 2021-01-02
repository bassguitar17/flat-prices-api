package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.roman.flats.domain.name.NameCity;
import ua.roman.flats.domain.name.NameDistrict;
import ua.roman.flats.domain.name.NameVoivodeship;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String street;
    private int buildingNumber;
    private int flatNumber;
    private int distanceToMainStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_VOIVODESHIP)
    private NameVoivodeship nameVoivodeship;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_CITY)
    private NameCity nameCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_DISTRICT)
    private NameDistrict nameDistrict;

    @OneToMany(mappedBy = ConstantsDatabase.ADDRESS, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();
}
