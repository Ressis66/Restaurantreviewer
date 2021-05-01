package com.restorauntreviewer.service;
import java.util.List;


import com.restorauntreviewer.model.Restaurant;
import com.restorauntreviewer.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantRepository repository;
    @Override
    public Restaurant retrieve(long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void delete(long id)  {
        repository.delete(id);
    }
    @Override
    public Restaurant create(Restaurant newRestaurant) {
        return repository.save(newRestaurant);
    }

    @Override
    public void update(Restaurant newRestaurant, long id) throws IllegalArgumentException {
        repository.save(newRestaurant);
    }

    @Override
    public List<Restaurant> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}
