package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("select p from Post p where p.id = :id")
    Optional<Post> findOneById(@Param("id") Long id);
}
