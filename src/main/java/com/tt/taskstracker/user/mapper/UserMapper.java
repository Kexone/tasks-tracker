package com.tt.taskstracker.user.mapper;

import com.tt.taskstracker.user.model.UserDto;
import com.tt.taskstracker.user.repository.UserDao;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserDto userDaoToUserDto(UserDao userDao);
}
