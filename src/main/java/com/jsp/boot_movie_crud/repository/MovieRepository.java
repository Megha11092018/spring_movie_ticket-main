package com.jsp.boot_movie_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.boot_movie_crud.entity.Movie;



public interface MovieRepository extends  JpaRepository<Movie, Long> {

}
