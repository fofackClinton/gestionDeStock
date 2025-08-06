package com.fintech.gestionDeStock.controllers.api;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.fintech.gestionDeStock.utils.constants.APP_ROOT;

import com.fintech.gestionDeStock.dto.ArticleDto;

public interface ArticleApi {
    
    @PostMapping(path = APP_ROOT+ "/articles/create", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto save(@RequestBody ArticleDto dto);
    

    @GetMapping(path= APP_ROOT+ "/articles/{idArticle}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(path= APP_ROOT+ "/articles/{codeArticle}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findByCodeArticle(String codeArticle);
    
    @GetMapping(path= APP_ROOT+ "/articles/all", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> findAll();

    @DeleteMapping(path=APP_ROOT+ "/articles/delete")
    public void delete(Integer id);

}
