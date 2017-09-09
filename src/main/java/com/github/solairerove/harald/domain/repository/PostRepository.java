package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM post WHERE id = ?1", nativeQuery = true)
    Optional<Post> findOneById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE post SET " +
            "title = COALESCE(?2, title), " +
            "author = COALESCE(?3, author), " +
            "date = COALESCE(?4, date), " +
            "content = COALESCE(CAST(?5 AS TEXT), content) " +
            "WHERE id = ?1", nativeQuery = true)
    void updateOneById(Long id, String title, String author, String date, String content);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM post WHERE id = ?1", nativeQuery = true)
    void deletePostById(Long id);
}
