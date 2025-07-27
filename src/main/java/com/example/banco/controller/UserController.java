package com.example.banco.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banco.domain.User;
import com.example.banco.model.UserDTO;
import com.example.banco.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> all() {
        return service.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOne(@PathVariable Long id) {
        User user = service.findById(id); // Agora sempre retorna ou lança exceção
        return ResponseEntity.ok(toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody User user) {
        User saved = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(saved));
    }

    private UserDTO toDto(User u) {
        UserDTO dto = new UserDTO();
        dto.setName(u.getName());
        dto.setAccountNumber(u.getAccount().getNumber());
        dto.setAgency(u.getAccount().getAgency());
        dto.setBalance(u.getAccount().getBalance());
        dto.setLimit(u.getAccount().getLimit());
        return dto;
    }
}
