package edu.personal.task.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.personal.task.dto.UserDto;
import edu.personal.task.entity.User;
import edu.personal.task.repository.UserRepository;
import edu.personal.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public UserDto getUser(Long id) {
        Iterable<User> users = userRepository.findAll();
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user=iterator.next();
            UserDto userDto = mapper.convertValue(user,UserDto.class);
            if (userDto.getId()==id){
                return userDto;
            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public User createUser(UserDto userDto) {
        if (!userDto.getUserName().isEmpty()||!userDto.getPassword().isEmpty()) {
            User user = mapper.convertValue(userDto, User.class);
            return userRepository.save(user);
        }
        return new User((long) 0,"error","error");
    }

    @Override
    public Boolean deleteUser(UserDto userDto) {
        User user=mapper.convertValue(userDto,User.class);
        userRepository.delete(user);
        return null;
    }

    @Override
    public ArrayList<UserDto> getUsers() {
        ArrayList<UserDto> list=new ArrayList<>();
        Iterable<User> allUsers = userRepository.findAll();
        Iterator<User> all = allUsers.iterator();
        while (all.hasNext()){
            User user=all.next();
            UserDto userDto=mapper.convertValue(user,UserDto.class);
            list.add(userDto);
        }
        return list;
    }
}