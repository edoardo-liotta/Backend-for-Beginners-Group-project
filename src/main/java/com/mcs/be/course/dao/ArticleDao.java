package com.mcs.be.course.dao;

import com.mcs.be.course.model.Article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

	List<Article> findByTitleContaining(String title);


}
