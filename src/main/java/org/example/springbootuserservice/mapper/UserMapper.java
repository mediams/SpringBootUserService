package org.example.springbootuserservice.mapper;

import org.example.springbootuserservice.dto.UserCreateDto;
import org.example.springbootuserservice.dto.UserDto;
import org.example.springbootuserservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDto(List<User> users);

    @Mapping(target = "id", ignore = true)
    User createDtoToEntity(UserCreateDto dto);
}
