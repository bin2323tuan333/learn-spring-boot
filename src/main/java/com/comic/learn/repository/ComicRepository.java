package com.comic.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comic.learn.entity.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {

}
