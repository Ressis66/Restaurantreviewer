package com.restorauntreviewer.controller.usercontroller;

import com.restorauntreviewer.model.Restaurant;
import com.restorauntreviewer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = UserRestaurantController.REST_URL)
public class UserRestaurantController {
    public static final String REST_URL = "/api/v1/users/restaurants";

    @Autowired
    private RestaurantService service;


    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
