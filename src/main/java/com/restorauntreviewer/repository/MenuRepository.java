package com.restorauntreviewer.repository;

import com.restorauntreviewer.model.Dish;
import com.restorauntreviewer.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MenuRepository extends JpaRepository<Menu, Long> {


}
