package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Models.Comment;
import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Repositories.CommentRepository;
import com.farukkavlak.hw1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment, int commentedUser_id) {
        User commentedUser = userRepository.findById(commentedUser_id).orElse(null);
        comment.setUser(commentedUser);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteCommentById(int deletedComment_id) {
        commentRepository.deleteById(deletedComment_id);
    }

    @Override
    public Comment updateCommentById(String commentText, int updatedComment_id) {
        Comment updatedComment = commentRepository.findById(updatedComment_id).orElse(null);
        updatedComment.setCommentText(commentText);
        commentRepository.save(updatedComment);
        return updatedComment;
    }
}
