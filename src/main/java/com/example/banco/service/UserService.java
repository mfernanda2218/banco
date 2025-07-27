package com.example.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.banco.domain.User;
import com.example.banco.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public List<User> findAll() {
    return repo.findAll();
  }

  public Optional<User> findById(Long id) {
    return repo.findById(id);
  }

  public User save(User user) {
    return repo.save(user);
  }
}


