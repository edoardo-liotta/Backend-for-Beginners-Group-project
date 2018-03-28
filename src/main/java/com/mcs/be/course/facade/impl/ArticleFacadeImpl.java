package com.mcs.be.course.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.ArticleFacade;
import com.mcs.be.course.model.Article;
import com.mcs.be.course.service.ArticleService;

import ma.glasnost.orika.MapperFacade;

@Component
public class ArticleFacadeImpl implements ArticleFacade {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public List<ArticleDto> retrieveAllArticles() {
        List<Article> articles = articleService.retrieveAllArticles();

        List<ArticleDto> articleDtoList = articles.stream()
                .map(a -> mapperFacade.map(a,ArticleDto.class))
                .collect(Collectors.toList());


        return articleDtoList;
    }

    @Override
    public ArticleDto retrieveArticleById(Long id) throws ElementNotFound {
        Article article = articleService.retrieveArticleById(id);
        return mapperFacade.map(article, ArticleDto.class);
    }

    @Override
    public ArticleDto saveOrUpdate(ArticleDto articleDto) throws ElementNotFound {

        Article article = mapperFacade.map(articleDto, Article.class);

        if(article.getId() != null){
            article = articleService.updateArticle(article);
        } else {
            article = articleService.saveArticle(article);
        }

        ArticleDto targetArticleDto = mapperFacade.map(article, ArticleDto.class);
		return targetArticleDto;
    }

    @Override
    public ArticleDto addLikeToArticle(Long id) throws ElementNotFound {
        Article article = articleService.addLikeToArticle(id);
        return mapperFacade.map(article, ArticleDto.class);
    }

	@Override
	public List<ArticleDto> findArticlesByTitle(String title) throws ElementNotFound {
		List<Article> articles = articleService.findArticlesByTitle(title);
		
		List<ArticleDto> articleDtoList = articles.stream()
                .map(a -> mapperFacade.map(a,ArticleDto.class))
                .collect(Collectors.toList());

		return articleDtoList;
	}
}
