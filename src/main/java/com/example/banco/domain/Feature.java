package com.example.banco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_feature")
public class Feature extends BaseItem {

    @ManyToOne
    @JsonIgnore
    private User user;

    // getter e setter de user
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
