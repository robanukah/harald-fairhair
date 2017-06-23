package com.github.solairerove.facepalm.domain.repository;

import com.github.solairerove.facepalm.domain.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

}
