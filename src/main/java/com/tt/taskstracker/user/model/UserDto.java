package com.tt.taskstracker.user.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    String id;
    String email;
    String firstName;
    String lastName;
    String nickname;
    UserRole role;
    Boolean isActive;
}
