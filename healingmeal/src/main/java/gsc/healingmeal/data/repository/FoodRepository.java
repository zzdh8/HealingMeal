package gsc.healingmeal.data.repository;

import gsc.healingmeal.data.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
