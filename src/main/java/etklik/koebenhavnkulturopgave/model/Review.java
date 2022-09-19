package etklik.koebenhavnkulturopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private int rating;

    @ManyToOne
    @JsonBackReference (value="Review-band") //Undgår et evigt cirkulært metodekald fra @RestController
    @EqualsAndHashCode.Exclude //pga. hashCode fra @Data
    private Event event;

    @ManyToOne
    @JsonBackReference (value="Review-User") //Undgår et evigt cirkulært metodekald fra @RestController
    @EqualsAndHashCode.Exclude //pga. hashCode fra @Data
    private User user;
}
