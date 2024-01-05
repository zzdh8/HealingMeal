package gsc.healingmeal.data.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    private String foodCode;
    private String foodName;
    private String dataClassificationCode;
    private String dataClassificationName;
    private Long foodOriginCode;
    private String foodOriginName;
    private String foodMajorCategoryCode;
    private String foodMajorCategoryName;
    private String representativeFoodCode;
    private String representativeFoodName;
    private String foodMiddleCategoryCode;
    private String foodMiddleCategoryName;
    private String foodSubCategoryCode;
    private String foodSubCategoryName;
    private String foodDetailCategoryCode;
    private String foodDetailCategoryName;
    private String nutrientContentStandardAmount;
    private double energy;
    private double water;
    private double protein;
    private double fat;
    private double ash;
    private double carbohydrate;
    private double sugar;
    private double dietaryFiber;
    private double calcium;
    private double iron;
    private double phosphorus;
    private double potassium;
    private double sodium;
    private double vitaminA;
    private double retinol;
    private double betaCarotene;
    private double thiamine;
    private double riboflavin;
    private double niacin;
    private double vitaminC;
    private double vitaminD;
    private double cholesterol;
    private double saturatedFattyAcid;
    private double transFattyAcid;
    private Long sourceCode;
    private String sourceName;
    private String foodWeight;
    private String company;
    private Long dataCreationMethodCode;
    private String dataCreationMethodName;
    private String dataCreationDate;
    private String dataBaseDate;
    private Long providerCode;
    private String providerName;


    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                "foodCode='" + foodCode + '\'' +
                ", foodName='" + foodName + '\'' +
                ", dataClassificationCode='" + dataClassificationCode + '\'' +
                ", dataClassificationName='" + dataClassificationName + '\'' +
                ", foodOriginCode=" + foodOriginCode +
                ", foodOriginName='" + foodOriginName + '\'' +
                ", foodMajorCategoryCode='" + foodMajorCategoryCode + '\'' +
                ", foodMajorCategoryName='" + foodMajorCategoryName + '\'' +
                ", representativeFoodCode='" + representativeFoodCode + '\'' +
                ", representativeFoodName='" + representativeFoodName + '\'' +
                ", foodMiddleCategoryCode='" + foodMiddleCategoryCode + '\'' +
                ", foodMiddleCategoryName='" + foodMiddleCategoryName + '\'' +
                ", foodSubCategoryCode='" + foodSubCategoryCode + '\'' +
                ", foodSubCategoryName='" + foodSubCategoryName + '\'' +
                ", foodDetailCategoryCode='" + foodDetailCategoryCode + '\'' +
                ", foodDetailCategoryName='" + foodDetailCategoryName + '\'' +
                ", nutrientContentStandardAmount='" + nutrientContentStandardAmount + '\'' +
                ", energy=" + energy +
                ", water=" + water +
                ", protein=" + protein +
                ", fat=" + fat +
                ", ash=" + ash +
                ", carbohydrate=" + carbohydrate +
                ", sugar=" + sugar +
                ", dietaryFiber=" + dietaryFiber +
                ", calcium=" + calcium +
                ", iron=" + iron +
                ", phosphorus=" + phosphorus +
                ", potassium=" + potassium +
                ", sodium=" + sodium +
                ", vitaminA=" + vitaminA +
                ", retinol=" + retinol +
                ", betaCarotene=" + betaCarotene +
                ", thiamine=" + thiamine +
                ", riboflavin=" + riboflavin +
                ", niacin=" + niacin +
                ", vitaminC=" + vitaminC +
                ", vitaminD=" + vitaminD +
                ", cholesterol=" + cholesterol +
                ", saturatedFattyAcid=" + saturatedFattyAcid +
                ", transFattyAcid=" + transFattyAcid +
                ", sourceCode=" + sourceCode +
                ", sourceName='" + sourceName + '\'' +
                ", foodWeight='" + foodWeight + '\'' +
                ", company='" + company + '\'' +
                ", dataCreationMethodCode=" + dataCreationMethodCode +
                ", dataCreationMethodName='" + dataCreationMethodName + '\'' +
                ", dataCreationDate=" + dataCreationDate +
                ", dataBaseDate=" + dataBaseDate +
                ", providerCode=" + providerCode +
                ", providerName='" + providerName + '\'' +
                '}';
    }



}

