package com.farukkavlak.hw1.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CommentTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 500)
    private String commentText;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date commentDate;
    private Long productId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "UserComment_fk",referencedColumnName = "id")
    public User user;
}
