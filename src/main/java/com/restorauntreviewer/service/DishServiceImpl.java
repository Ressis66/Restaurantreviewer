package com.restorauntreviewer.service;

import com.restorauntreviewer.model.Dish;
import com.restorauntreviewer.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishServiceImpl implements DishService {


    @Autowired
    private DishRepository repository;

    @Override
    public List<Dish> getAll() {

        return repository.findAll();
    }

    @Override
    public Dish retrieve(long id)  {

        return repository.findById(id).get();
    }

    @Override
    public void delete(long id)  {

        repository.delete(id);
    }

    @Override
    public Dish create(Dish newDish) {

        return repository.save(newDish);
    }

    @Override
    public void update(Dish newDish, long id) {

        repository.save(newDish);
    }
}
