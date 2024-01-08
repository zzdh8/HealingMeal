package gsc.healingmeal.survey.doamin;

import gsc.healingmeal.member.domain.Gender;
import gsc.healingmeal.member.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Survey_id")
    private Long id;

    private Long age;

    private String destination; // 목표

    private Long diabetesType; // 당뇨유형

    private Long numberOfExercises; // 육체 활동 빈도

    private Long height;

    private Long weight;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double standardWeight; // 표준 채중

    private Long bodyMassIndex; // 체질량지수

    private Long CaloriesNeededPerDay; // 하루 필요 열량

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FilterFood> filterFoods = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
