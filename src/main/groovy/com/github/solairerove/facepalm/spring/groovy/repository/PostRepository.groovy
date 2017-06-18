package com.github.solairerove.facepalm.spring.groovy.repository

import com.github.solairerove.facepalm.spring.groovy.domain.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = false)
interface PostRepository extends JpaRepository<Post, Integer> {

}