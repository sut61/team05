package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findById(long id);
}
