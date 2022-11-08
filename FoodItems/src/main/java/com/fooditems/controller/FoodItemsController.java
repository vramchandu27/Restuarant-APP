package com.fooditems.controller;

import com.fooditems.Repository.FoodItemsRepo;
import com.fooditems.model.FoodItems;
import com.fooditems.service.FoodItemsImpl;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/foodItems")
public class FoodItemsController {
    @Autowired
    private FoodItemsImpl foodItemsImpl;

    @Autowired
    private FoodItemsRepo foodItemsRepo;

    @GetMapping("/showAll")
    public ResponseEntity showFoodDetails(){
        try{
            return ResponseEntity.ok(foodItemsRepo.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping("/showById/{foodId}")
    public ResponseEntity showFoodDetailsById(@PathVariable Long foodId){
        try{
            return ResponseEntity.ok(foodItemsImpl.getFoodBy(foodId));
        }catch (Exception e){
            System.out.println("No Food");
            return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping("/showByName/{foodName}")
    public ResponseEntity showFoodDetailsById(@PathVariable String foodName){
        try{
            return ResponseEntity.ok(foodItemsImpl.getFoodBy(foodName));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<FoodItems> addFood(@RequestBody FoodItems foodItems){
        return ResponseEntity.ok(foodItemsImpl.addFood(foodItems));
    }


}

