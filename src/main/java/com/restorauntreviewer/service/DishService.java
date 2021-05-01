package com.restorauntreviewer.service;
import com.restorauntreviewer.model.Dish;
import org.springframework.security.access.annotation.Secured;

import java.util.List;


public interface DishService {

    List<Dish> getAll();

    Dish retrieve(long id) ;


    void delete(long id) ;

    Dish create(Dish dish);


    void update(Dish dish, long id) ;
}
