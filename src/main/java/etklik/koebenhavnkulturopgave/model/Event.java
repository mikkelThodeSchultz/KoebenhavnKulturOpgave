package etklik.koebenhavnkulturopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateTime;
    private String venue;

    @ManyToOne
    @JsonBackReference //Undgår et evigt cirkulært metodekald fra @RestController
    @EqualsAndHashCode.Exclude //pga. hashCode fra @Data
    private Band band;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();

}
