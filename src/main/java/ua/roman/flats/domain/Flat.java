package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.roman.flats.domain.name.NameDistrict;
import ua.roman.flats.domain.type.TypeHeating;
import ua.roman.flats.domain.type.TypeMarket;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int area;
    private BigDecimal price;
    private int numberOfRooms;
    private String city;

    @OneToMany(mappedBy = ConstantsDatabase.FLAT, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_HEATING)
    private TypeHeating typeHeating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_MARKET)
    private TypeMarket typeMarket;

    public Flat(int area, BigDecimal price, int numberOfRooms, String city) {
        this.area = area;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
        this.city = city;
    }
}
