package ua.roman.flats.domain.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeHeating {

    @Id
    private String id;

    private String name;

    public TypeHeating(String name) {
        this.name = name;
    }
}