package com.fooditems.service;

import com.fooditems.Repository.FoodItemsRepo;
import com.fooditems.model.FoodItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodItemsImpl implements IFoodItems{
    @Autowired
    private FoodItemsRepo foodItemsRepo;

    @Override
    public FoodItems addFood(FoodItems foodItems) {
        return foodItemsRepo.save(foodItems);
    }

    @Override
    public Optional<FoodItems> getFoodBy(Long foodId) throws Exception {
        System.out.println("Inside by id");
        if(foodItemsRepo.findById(foodId).isEmpty()){
            System.out.println("empty by id");
            throw new Exception("No Food Item Found");
        }else{
            return foodItemsRepo.findById(foodId);
        }
    }

    @Override
    public List<FoodItems> getFoodBy(String foodName) throws Exception {
        System.out.println("Inside by name");
        if(foodItemsRepo.findByFoodName(foodName).isEmpty()){
            throw new Exception("No Food Item Found");
        }else{
            return foodItemsRepo.findByFoodName(foodName);
        }
    }

    @Override
    public Long deleteFood(String foodName) throws Exception {
        if(foodItemsRepo.findByFoodName(foodName).isEmpty()){
            System.out.println("empty by id");
            throw new Exception("Item not Present");
        }else{
            return foodItemsRepo.deleteByFoodName(foodName);
        }
    }

}

