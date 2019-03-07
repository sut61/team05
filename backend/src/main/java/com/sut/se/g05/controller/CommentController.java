package com.sut.se.g05.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class CommentController {

    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private GenderRepository genderRepository;


    @GetMapping("/Comment")
    public Collection <Comment> Commment() { return commentRepository.findAll().stream().collect(Collectors.toList());}

    @GetMapping("/Level")
    public Collection<Level> Level(){
        return levelRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Comment/{level1}/{name}/{phone}/{post}/{provinceId}/{genderId}")
    public Comment newComment(Comment newComment,@PathVariable Long level1,@PathVariable String name,@PathVariable String phone,
                              @PathVariable String post, @PathVariable Long provinceId, @PathVariable Long genderId) {

        Level levels1 = levelRepository.findByLevelId(level1);

        Optional<Province> province = provinceRepository.findById(provinceId);
        Optional<Gender> gender = genderRepository.findById(genderId);

        newComment.setPhone(phone);
        newComment.setName(name);
        newComment.setPost(post);
        newComment.setGender(gender.get());
        newComment.setProvince(province.get());
        newComment.setCommentDate(new Date());
        newComment.setCommentTime(new Timestamp(System.currentTimeMillis()));

        return  commentRepository.save(newComment);
    }
}
