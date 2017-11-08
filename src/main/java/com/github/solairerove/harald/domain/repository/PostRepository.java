package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM post WHERE id = ?1", nativeQuery = true)
    Post findOneById(Long id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM post", nativeQuery = true)
    List<Post> findAll();
}
