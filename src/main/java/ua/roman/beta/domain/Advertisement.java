package ua.roman.beta.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String number;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampAddingToDatabase;

    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_flat")
    private Flat flat;

    public Advertisement(String number, Date creationTime) {
        this.number = number;
        this.creationTime = creationTime;
        this.timestampAddingToDatabase = new Date();
    }
}
