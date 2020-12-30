package ua.roman.beta.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "flat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    public Flat(int area, BigDecimal price, int numberOfRooms, String city) {
        this.area = area;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
        this.city = city;
    }
}
