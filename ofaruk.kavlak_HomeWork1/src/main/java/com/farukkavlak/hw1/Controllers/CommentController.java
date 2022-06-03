package com.farukkavlak.hw1.Controllers;

import com.farukkavlak.hw1.Models.Comment;
import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Repositories.CommentRepository;
import com.farukkavlak.hw1.Repositories.UserRepository;
import com.farukkavlak.hw1.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("saveComment/{commentedUser_id}")
    public String saveComment(@RequestBody Comment comment,@PathVariable("commentedUser_id") int commentedUser_id){
        commentService.saveComment(comment,commentedUser_id);
        return "Comment Saved(id="+comment.getId()+")";
    }

    @GetMapping("findAllComments")
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @DeleteMapping("deleteCommentById/{deletedComment_id}")
    public String deleteCommentById(@PathVariable("deletedComment_id") int deletedComment_id){
        commentService.deleteCommentById(deletedComment_id);
        return "Comment Deleted(id="+deletedComment_id+")";
    }

    @PutMapping("updateCommentById/{updatedComment_id}")
    public String updateCommentById(@RequestBody String commentText,@PathVariable("updatedComment_id") int updatedComment_id){
        commentService.updateCommentById(commentText,updatedComment_id);
        return "Comment Updated(id="+updatedComment_id+")";
    }
}
