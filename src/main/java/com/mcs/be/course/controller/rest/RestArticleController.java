package com.mcs.be.course.controller.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcs.be.course.dto.ArticleDto;
import com.mcs.be.course.exception.ElementNotFound;
import com.mcs.be.course.facade.ArticleFacade;

@RestController
@RequestMapping(value = "/articles")
public class RestArticleController {

	private static final Logger LOGGER = LogManager.getLogger(RestArticleController.class);

	@Autowired
	private ArticleFacade articleFacade;

	@RequestMapping(method = RequestMethod.GET)
	public List<ArticleDto> getArticles() {
		return articleFacade.retrieveAllArticles();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ArticleDto> createOrUpdateArticle(@RequestBody ArticleDto articleDto) throws ElementNotFound {
		ArticleDto saveOrUpdate = articleFacade.saveOrUpdate(articleDto);
		return new ResponseEntity<ArticleDto>(saveOrUpdate, null == articleDto.getId() ? HttpStatus.CREATED : HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET)
	public ArticleDto getArticle(@PathVariable String id) throws ElementNotFound {
		return articleFacade.retrieveArticleById(Long.valueOf(id));
	}
	
	@RequestMapping(value = "/like", method = RequestMethod.PATCH)
	public ArticleDto toggleLike(@RequestBody ArticleDto articleDto) throws ElementNotFound {
		return articleFacade.addLikeToArticle(articleDto.getId());
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<ArticleDto> findArticlesByTitle(@RequestParam String title) throws ElementNotFound {
		return articleFacade.findArticlesByTitle(title);
	}

}
