package com.fintech.gestionDeStock.controllers.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fintech.gestionDeStock.dto.ArticleDto;

import io.swagger.v3.oas.annotations.Operation;

import static com.fintech.gestionDeStock.utils.constants.APP_ROOT;



@RequestMapping(APP_ROOT + "/articles")
public interface ArticleApi {

        @Operation(summary = "modification de l'objet article")
        // @ApiResponses(value = {
        // @ApiResponse(responseresponseCode = 200, description = "L'object article cree
        // / modifier",
        // content ={@Content(mediaType="application/json")}),
        // @ApiResponse(responseresponseCode = 400, description = "l'object article
        // n'est pas valide",
        // content ={@Content})
        // })
        @PostMapping(path = APP_ROOT
                        + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ArticleDto save(@RequestBody ArticleDto dto);

        @Operation(summary = "cherché un article")
        // @ApiResponses(value = {
        // @ApiResponse(responseCode = 200, description = "l'article a été trouver dans
        // la BDD"),
        // @ApiResponse(responseCode = 404, description = "aucun object n'existe dans la
        // BDD avec l'id fournie")
        // })
        @GetMapping(path = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ArticleDto findById(@PathVariable("idArticle") Integer id);

        @Operation(summary = "recherché un  article par son code")
        // @ApiResponses(value = {
        // @ApiResponse(responseCode = 200, description = "l'article a été trouver dans
        // la BDD"),
        // @ApiResponse(responseCode = 404, description = "aucun object n'existe dans la
        // BDD avec l'id fournie")
        // })
        @GetMapping(path = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ArticleDto findByCodeArticle(String codeArticle);

        @Operation(summary = "listé tout les articles")
        // @ApiResponses(value = {
        // @ApiResponse(responseCode = 200, description = "la liste des article/une
        // liste vide"),
        // })
        @GetMapping(path = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<ArticleDto> findAll();

        @Operation(summary = "permet de supprimé un article")
        // @ApiResponses(value = {
        // @ApiResponse(responseCode = 200, description = "l'article a été supprimé"),
        // })
        @DeleteMapping(path = APP_ROOT + "/articles/delete")
        public void delete(Integer id);

}
