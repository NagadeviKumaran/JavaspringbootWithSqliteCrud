package com.example.crudwithsqlite.Service;

import com.example.crudwithsqlite.DTO.UserDto;
import com.example.crudwithsqlite.Entity.User;
import com.example.crudwithsqlite.Mapper.EntityMapper;
import com.example.crudwithsqlite.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class USerServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EntityMapper entityMapper;
    @Override
    public List<UserDto> getAllEmployees() {
        return userRepo.findAll().stream().map(entityMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDto getBtId(Long id) {
        return userRepo.findById(id).map(entityMapper::toDTO).orElse(null);
    }

    @Override
    public UserDto createEmployee(UserDto userDto) {
        User user=entityMapper.toEntity(userDto);
        User savedUser=userRepo.save(user);
        return entityMapper.toDTO(savedUser);

    }

    @Override
    public UserDto updateEmployee(Long id, UserDto userDto) {
        return userRepo.findById(id).map(existingUser->{
            existingUser.setName(userDto.getName());
            existingUser.setEmail(userDto.getEmail());
            return entityMapper.toDTO(userRepo.save(existingUser));
        }).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        userRepo.deleteById(id);

    }
}
