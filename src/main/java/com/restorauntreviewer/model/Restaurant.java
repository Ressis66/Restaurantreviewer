package com.restorauntreviewer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "restaurant")
@JsonIgnoreProperties(value= {"menus","votes"})
public class Restaurant extends BaseEntity {


    @NotNull
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    @OrderBy("created DESC")
    protected List<Vote> votes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    @OrderBy("created DESC")
    protected List<Menu> menus;





    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
