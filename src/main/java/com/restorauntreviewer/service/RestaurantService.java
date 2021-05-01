package com.restorauntreviewer.service;

import com.restorauntreviewer.model.Restaurant;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface RestaurantService {

    Restaurant retrieve(long id) ;


    void delete(long id);


    Restaurant create(Restaurant restaurant);


    void update(Restaurant restaurant, long id);


    List<Restaurant> findByTitle(String title);



    List<Restaurant> getAll();
}
