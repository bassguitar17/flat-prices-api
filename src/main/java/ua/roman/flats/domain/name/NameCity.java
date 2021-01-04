package ua.roman.flats.domain.name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.roman.flats.domain.Address;
import ua.roman.flats.domain.ConstantsDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = ConstantsDatabase.NAME_CITY, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    public NameCity(String name) {
        this.name = name;
    }
}
