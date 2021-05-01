package com.restorauntreviewer.service;
import com.restorauntreviewer.model.Dish;
import org.springframework.security.access.annotation.Secured;

import java.util.List;


public interface DishService {

    List<Dish> getAll();

    Dish retrieve(int id) ;


    void delete(int id) ;

    Dish create(Dish dish);


    void update(Dish dish, int id) ;
}
