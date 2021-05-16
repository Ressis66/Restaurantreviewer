package com.restorauntreviewer.controller.usercontroller;

import com.restorauntreviewer.model.Dish;
import com.restorauntreviewer.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = UserDishController.REST_URL)
public class UserDishController {

    public static final String REST_URL = "/api/v1/users/dishs";
    @Autowired
    private DishService service;

    @GetMapping
    public ResponseEntity<List<Dish>> getAll() {

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Dish retrieve(@PathVariable("id") int id) {

        return service.retrieve(id);
    }

}
