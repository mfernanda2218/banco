package com.example.banco.domain;

import jakarta.persistence.Entity;

@Entity(name = "tb_news")
public class News extends BaseItem {
    // não há referência para User (unidirecional)
}
