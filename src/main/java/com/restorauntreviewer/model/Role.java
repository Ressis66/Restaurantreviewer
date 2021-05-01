package com.restorauntreviewer.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Simple domain object that represents application user's role - ADMIN, USER, etc.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Entity
@Table(name = "roles")

public class Role extends BaseEntity implements GrantedAuthority {


    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Role(Long id, String name, Date created, Date updated, Status status) {
        super(id, created, updated, status);
        this.name=name;
    }
    public Role(Long id) {
        super(id);
    }

    public Role() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Role{" +
            "name: " + name + "}";
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
