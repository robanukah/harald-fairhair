package com.github.solairerove.facepalm.repository;

import com.github.solairerove.facepalm.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

}
