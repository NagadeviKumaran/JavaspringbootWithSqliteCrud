package com.example.crudwithsqlite.Controller;

import com.example.crudwithsqlite.DTO.UserDto;
import com.example.crudwithsqlite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class EmployeeController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto>getAllEmployees(){
        return userService.getAllEmployees();
    }

    @GetMapping("{id}")
    public UserDto getEmployeeById(@PathVariable Long id){
        return userService.getBtId(id);
    }

    @PostMapping
    public UserDto createEmployee(@RequestBody UserDto userDto){
        return userService.createEmployee(userDto);
    }
    @PutMapping("{id}")
    public UserDto updateEmployee(@PathVariable Long id,@RequestBody UserDto userDto){
        return userService.updateEmployee(id,userDto);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteEmployee(id);
        return "employee deleted";
    }
}
