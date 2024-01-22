package edu.personal.task.service;

import edu.personal.task.dto.UserDto;
import edu.personal.task.entity.User;

import java.util.ArrayList;

public interface UserService {
    public UserDto getUser(Long id);

    public User createUser(UserDto userDto);

    Boolean deleteUser(UserDto userDto);

    ArrayList<UserDto> getUsers();

    UserDto editUsers(UserDto userDto);
}
