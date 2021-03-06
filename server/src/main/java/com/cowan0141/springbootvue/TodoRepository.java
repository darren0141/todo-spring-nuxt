package com.cowan0141.springbootvue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface TodoRepository extends JpaRepository<Todo, Long>{}