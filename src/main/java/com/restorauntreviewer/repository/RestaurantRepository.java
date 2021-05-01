package com.restorauntreviewer.repository;

import com.restorauntreviewer.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r ORDER BY r.name")
    List<Restaurant> getAll();

    @Transactional
    @Override
    Restaurant save(Restaurant restaurant);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") long id);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE CONCAT('%', :name, '%')")
    List<Restaurant> findByTitle(@Param("name") String name);


}
