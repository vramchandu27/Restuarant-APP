package com.fooditems.service;

import com.fooditems.model.FoodItems;

import java.util.List;
import java.util.Optional;

public interface IFoodItems {
    public FoodItems addFood(FoodItems foodItems);

    Optional<FoodItems> getFoodBy(Long foodId) throws Exception;

    List<FoodItems> getFoodBy(String foodName) throws Exception;

    public Long deleteFood(String foodName) throws Exception;
}
