package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.roman.flats.domain.type.TypeLandlord;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String telephone;
    private String emailAddress;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_LANDLORD_TYPE)
    private TypeLandlord typeLandlord;

    @OneToMany(mappedBy = ConstantsDatabase.LANDLORD, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();
}
