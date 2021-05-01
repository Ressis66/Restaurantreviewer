package com.restorauntreviewer.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "vote")
public class Vote extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @Column(name = "dcreated", columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDate dcreated = LocalDate.now();

    @Column(name = "rate")
    @NotNull
    private Double rate;

    public Vote() {

    }

    public Vote(LocalDate dcreated, Double rate) {
        this(null, dcreated, rate);
    }

    public Vote(Long id, LocalDate dcreated, Double rate) {
        super(id);
        this.dcreated = dcreated;
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDcreated() {
        return dcreated;
    }

    public void setDcreated(LocalDate created) {
        this.dcreated = created;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}

