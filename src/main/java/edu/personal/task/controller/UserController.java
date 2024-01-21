package edu.personal.task.controller;

import edu.personal.task.dto.UserDto;
import edu.personal.task.entity.User;
import edu.personal.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/get{id}")
    public UserDto getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
    @DeleteMapping("/delete")
    public Boolean deleteUser(@RequestBody UserDto userDto){
        return userService.deleteUser(userDto);
    }
    @GetMapping("get/all")
    public ArrayList<UserDto> getAllUsers(){
        return userService.getUsers();
    }
    @PatchMapping("/edit")
    public void editUser(){

    }
}
