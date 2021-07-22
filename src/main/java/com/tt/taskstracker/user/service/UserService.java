package com.tt.taskstracker.user.service;

import com.tt.taskstracker.user.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {

    Collection<UserDto> getUsers();
    UserDto getUser(String id);
    UserDto createUser(UserDto userDto);
    UserDto modifyUser(UserDto userDto);
    UserDto suspendUser(String userId);
    UserDto changeUserRole(String userId, String role);
}
