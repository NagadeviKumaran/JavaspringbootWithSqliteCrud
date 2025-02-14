package com.example.crudwithsqlite.Mapper;

import com.example.crudwithsqlite.DTO.UserDto;
import com.example.crudwithsqlite.Entity.User;
import org.springframework.stereotype.Component;

@Component

public class EntityMapper {

    public UserDto toDTO(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User toEntity(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
