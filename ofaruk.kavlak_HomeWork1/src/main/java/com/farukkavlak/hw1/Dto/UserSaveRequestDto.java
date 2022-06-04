package com.farukkavlak.hw1.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserSaveRequestDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private boolean isActive;
}