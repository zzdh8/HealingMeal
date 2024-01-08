package gsc.healingmeal.survey.doamin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filterfood_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
}
