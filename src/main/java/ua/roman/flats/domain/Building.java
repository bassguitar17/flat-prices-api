package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.roman.flats.domain.type.TypeConstruction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private int lift;
    private int numberOfFloors;
    private int floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_CONSTRUCTION_TYPE)
    private TypeConstruction typeConstruction;

    @OneToMany(mappedBy = ConstantsDatabase.BUILDING, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();
}
