package com.farukkavlak.hw1.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class CommentSaveRequestDto {
    private String commentText;
    private Date commentDate;
    private Long productId;
}
