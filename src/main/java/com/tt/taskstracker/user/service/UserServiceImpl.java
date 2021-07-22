package com.tt.taskstracker.user.service;

import com.tt.taskstracker.user.mapper.UserMapper;
import com.tt.taskstracker.user.model.UserDto;
import com.tt.taskstracker.user.model.UserRole;
import com.tt.taskstracker.user.repository.UserDao;
import com.tt.taskstracker.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Collection<UserDto> getUsers() {
        Collection<UserDao> users = userRepository.findAll();
        return users.stream().map(userMapper::userDaoToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(String id) {
        return userMapper.userDaoToUserDto(userRepository.findById(id).orElseGet(UserDao::new));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserDao userDao = UserDao.builder()
                .id(userDto.getEmail())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .nickname(userDto.getNickname())
                .role(userDto.getRole())
                .isActive(true)
                .build();
        UserDao savedUser = userRepository.save(userDao);
        return userMapper.userDaoToUserDto(savedUser);
    }

    @Override
    public UserDto modifyUser(UserDto userDto) {
        String userId = getUser(userDto.getId()).getId();
        UserDao userDao = UserDao.builder()
                .id(userId)
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .nickname(userDto.getNickname())
                .role(userDto.getRole())
                .build();
        return userMapper.userDaoToUserDto(userRepository.save(userDao));
    }

    @Override
    public UserDto suspendUser(String userId) {
        UserDao userDao = userRepository.getById(userId);
        userDao.setIsActive(false);
        return userMapper.userDaoToUserDto(userRepository.save(userDao));
    }

    @Override
    public UserDto changeUserRole(String userId, String role) {
        UserDao userDao = userRepository.getById(userId);
        userDao.setRole(UserRole.valueOf(role));
        return userMapper.userDaoToUserDto(userRepository.save(userDao));
    }
}
