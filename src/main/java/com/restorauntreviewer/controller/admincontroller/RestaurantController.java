package com.restorauntreviewer.controller.admincontroller;
import java.util.List;

import com.restorauntreviewer.View;
import com.restorauntreviewer.model.Restaurant;
import com.restorauntreviewer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value = RestaurantController.REST_URL)
public class RestaurantController {

    public static final String REST_URL = "/api/v1/admin/restaurants";

    @Autowired
    private RestaurantService service;


    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public Restaurant retrieve(@PathVariable("id") int id)  {

        return service.retrieve(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id)  {

        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant, UriComponentsBuilder ucBuilder) {

        Restaurant created = service.create(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(REST_URL + "/{id}").buildAndExpand(restaurant.getId()).toUri());
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Restaurant newRestaurant, @PathVariable("id") int id)  {

        service.update(newRestaurant, id);
    }
}
