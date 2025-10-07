package org.example.springbootuserservice.controller;

import jakarta.validation.Valid;
import org.example.springbootuserservice.dto.UserCreateDto;
import org.example.springbootuserservice.dto.UserDto;
import org.example.springbootuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserCreateDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping()
    public ResponseEntity<Page<UserDto>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(service.getPage(pageable));
    }
}
