package com.example.crudwithsqlite.Service;

import com.example.crudwithsqlite.DTO.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllEmployees();
    UserDto getBtId(Long id);
    UserDto createEmployee(UserDto userDto);
    UserDto updateEmployee(Long id, UserDto userDto);
    void deleteEmployee(Long id);

}
