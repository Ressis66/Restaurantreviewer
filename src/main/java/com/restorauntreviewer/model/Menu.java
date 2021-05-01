package com.restorauntreviewer.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menu")
@JsonIgnoreProperties(value= {"dishs"})
public class Menu extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    @OrderBy("id DESC")
    private List<Dish> dishs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    public Menu() {
    }


    public Menu(List<Dish> dishs) {
        this(null,  dishs);
    }

    public Menu(Long id,  List<Dish> dishs) {
        super(id);
        this.dishs=dishs;

    }

    public List<Dish> getDishs() {
        return dishs;
    }

    public void setMenuItems(List<Dish> dishs) {
        this.dishs = dishs;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
