package com.farukkavlak.hw1.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private boolean isActive;

}
