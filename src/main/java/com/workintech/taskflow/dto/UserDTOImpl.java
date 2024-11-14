package com.workintech.taskflow.dto;

import com.workintech.taskflow.entity.User;

public class UserDTOImpl {

    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null; // null kontrolü
        }

        // Entity'den DTO'ya dönüşüm
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null; // null kontrolü
        }

        // DTO'dan Entity'ye dönüşüm
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}

