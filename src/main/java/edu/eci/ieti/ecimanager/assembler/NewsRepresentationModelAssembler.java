package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.NewsController;
import edu.eci.ieti.ecimanager.model.News;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class NewsRepresentationModelAssembler implements RepresentationModelAssembler<News, EntityModel<News>> {

    @Override
    public EntityModel<News> toModel(News news) {
        return new EntityModel<News>(news,
                linkTo(NewsController.class).slash(news.getId()).withSelfRel(),
                linkTo(NewsController.class).withRel("news"));
    }

}
