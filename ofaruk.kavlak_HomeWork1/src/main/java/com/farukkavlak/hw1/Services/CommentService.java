package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Models.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment,int commentedUser_id);
    List<Comment> findAll();
    void deleteCommentById(int deletedComment_id);
    Comment updateCommentById(String commentText,int updatedComment_id);
}
