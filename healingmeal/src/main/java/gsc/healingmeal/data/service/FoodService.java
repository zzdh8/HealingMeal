package gsc.healingmeal.data.service;


import gsc.healingmeal.data.domain.Food;
import gsc.healingmeal.data.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.Reader;

@RequiredArgsConstructor
@EnableScheduling
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public void loadSave() throws Exception {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("/Users/inho/Downloads/csvjson.json");
        JSONArray records = (JSONArray) parser.parse(reader);
        // test url : /Users/inho/Desktop/test.json
//        JSONObject jsonObject = (JSONObject) parser.parse(reader);
//        JSONArray records = (JSONArray) jsonObject.get("records");

        for (Object record : records) {


            try{
                JSONObject tmp = (JSONObject) record;

                Food food = Food.builder()
                        .foodCode(tmp.get("식품코드").toString())
                        .foodName(tmp.get("식품명").toString())
                        .dataClassificationCode(tmp.get("데이터구분코드").toString())
                        .dataClassificationName(tmp.get("데이터구분명").toString())
                        .foodOriginCode((Long) tmp.get("식품기원코드"))
                        .foodOriginName(tmp.get("식품기원명").toString())
                        .foodMajorCategoryCode(tmp.get("식품대분류코드").toString())
                        .foodMajorCategoryName(tmp.get("식품대분류명").toString())
                        .representativeFoodCode(tmp.get("대표식품코드").toString())
                        .representativeFoodName(tmp.get("대표식품명").toString())
                        .foodMiddleCategoryCode(tmp.get("식품중분류코드").toString())
                        .foodMiddleCategoryName(tmp.get("식품중분류명").toString())
                        .foodSubCategoryCode(tmp.get("식품소분류코드").toString())
                        .foodSubCategoryName(tmp.get("식품소분류명").toString())
                        .foodDetailCategoryCode(tmp.get("식품세분류코드").toString())
                        .foodDetailCategoryName(tmp.get("식품세분류명").toString())
                        .nutrientContentStandardAmount(tmp.get("영양성분함량기준량").toString())
                        .energy(((Number) tmp.get("에너지(kcal)")).doubleValue())
                        .water(((Number) tmp.get("수분(g)")).doubleValue())
                        .protein(((Number) tmp.get("단백질(g)")).doubleValue())
                        .fat(((Number) tmp.get("지방(g)")).doubleValue())
                        .ash(((Number) tmp.get("회분(g)")).doubleValue())
                        .carbohydrate(((Number) tmp.get("탄수화물(g)")).doubleValue())
                        .sugar(((Number) tmp.get("당류(g)")).doubleValue())
                        .dietaryFiber(((Number) tmp.get("식이섬유(g)")).doubleValue())
                        .calcium(((Number) tmp.get("칼슘(mg)")).doubleValue())
                        .iron(((Number) tmp.get("철(mg)")).doubleValue())
                        .phosphorus(((Number) tmp.get("인(mg)")).doubleValue())
                        .potassium(((Number) tmp.get("칼륨(mg)")).doubleValue())
                        .sodium(((Number) tmp.get("나트륨(mg)")).doubleValue())
                        .vitaminA(((Number) tmp.get("비타민 A(μg RAE)")).doubleValue())
                        .retinol(((Number) tmp.get("레티놀(μg)")).doubleValue())
                        .betaCarotene(((Number) tmp.get("베타카로틴(μg)")).doubleValue())
                        .thiamine(((Number) tmp.get("티아민(mg)")).doubleValue())
                        .riboflavin(((Number) tmp.get("리보플라빈(mg)")).doubleValue())
                        .niacin(((Number) tmp.get("니아신(mg)")).doubleValue())
                        .vitaminC(((Number) tmp.get("비타민 C(mg)")).doubleValue())
                        .vitaminD(((Number) tmp.get("비타민 D(μg)")).doubleValue())
                        .cholesterol(((Number) tmp.get("콜레스테롤(mg)")).doubleValue())
                        .saturatedFattyAcid(((Number) tmp.get("포화지방산(g)")).doubleValue())
                        .transFattyAcid(((Number) tmp.get("트랜스지방산(g)")).doubleValue())
                        .sourceCode((Long) tmp.get("출처코드"))
                        .sourceName(tmp.get("출처명").toString())
                        .foodWeight(tmp.get("식품중량").toString())
                        .company(tmp.get("업체명").toString())
                        .dataCreationMethodCode((Long) tmp.get("데이터생성방법코드"))
                        .dataCreationMethodName(tmp.get("데이터생성방법명").toString())
                        .dataCreationDate(tmp.get("데이터생성일자").toString())
                        .dataBaseDate(tmp.get("데이터기준일자").toString())
                        .providerCode((Long) tmp.get("제공기관코드"))
                        .providerName(tmp.get("제공기관명").toString())
                        .build();





                foodRepository.save(food);
            }catch (ClassCastException e){
                System.err.println("ClassCastException 발생: " + e.getMessage());
            }





        }
    }

}
