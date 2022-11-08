package com.fooditems.Repository;

import com.fooditems.model.FoodItems;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodItemsRepo extends MongoRepository<FoodItems,Long> {
    List<FoodItems> findByFoodName(String foodName);
    Long deleteByFoodName(String foodName);
}
