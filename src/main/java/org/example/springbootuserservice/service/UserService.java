package org.example.springbootuserservice.service;

import org.example.springbootuserservice.dto.UserCreateDto;
import org.example.springbootuserservice.dto.UserDto;
import org.example.springbootuserservice.entity.User;
import org.example.springbootuserservice.mapper.UserMapper;
import org.example.springbootuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.repository = userRepository;
        this.mapper = mapper;
    }

    public List<UserDto> getAll() {
        return mapper.usersToUserDto(repository.findAll());
    }

    @Transactional
    public UserDto create(UserCreateDto dto) {
        User user = mapper.createDtoToEntity(dto);
        return mapper.userToUserDto(repository.save(user));
    }

    public Page<UserDto> getPage(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::userToUserDto);
    }
}
