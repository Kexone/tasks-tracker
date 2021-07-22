package com.tt.taskstracker.user.web;

import com.tt.taskstracker.user.model.UserDto;
import com.tt.taskstracker.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    Collection<UserDto> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserDto getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    UserDto modifyUser(@RequestBody UserDto userDto) {
        return userService.modifyUser(userDto);
    }

    @RequestMapping(value = "/suspend", method = RequestMethod.PATCH)
    UserDto suspendUser(@RequestBody String id) {
        return userService.suspendUser(id);
    }

    @RequestMapping(value = "/role", method = RequestMethod.PATCH)
    UserDto suspendUser(@RequestBody String id,@RequestBody String role) {
        return userService.changeUserRole(id, role);
    }
}
