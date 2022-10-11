package com.example.mymangausersystem.service.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String userName;
    private String email;
    private String password;

    public UserDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
