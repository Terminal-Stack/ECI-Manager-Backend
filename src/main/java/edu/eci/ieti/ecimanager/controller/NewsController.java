package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.NewsRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.NewsNotFoundException;
import edu.eci.ieti.ecimanager.model.News;
import edu.eci.ieti.ecimanager.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsRepresentationModelAssembler newsRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<News>> all() {
        List<EntityModel<News>> news = newsRepository.findAll().stream()
                .map(newsRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(news, linkTo(NewsController.class).withSelfRel());
    }

    @GetMapping("/{url}")
    public EntityModel<News> getById(@PathVariable String url) {
        News news = newsRepository.findByUrl(url).orElseThrow(() -> new NewsNotFoundException(url));

        return newsRepresentationModelAssembler.toModel(news);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody News newNews) throws URISyntaxException {
        EntityModel<News> entityModel = newsRepresentationModelAssembler
                .toModel(newsRepository.insert(newNews));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

}