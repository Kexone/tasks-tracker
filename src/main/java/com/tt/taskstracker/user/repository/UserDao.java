package com.tt.taskstracker.user.repository;

import com.tt.taskstracker.user.model.UserRole;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class UserDao {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name="email")
    private String email;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nickname")
    private String nickname;

    @Column(name="role")
    private UserRole role;

    @Column(name="active")
    private Boolean isActive;
}
