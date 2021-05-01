package com.restorauntreviewer.repository;

import com.restorauntreviewer.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
