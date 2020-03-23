package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.model.News;
import edu.eci.ieti.ecimanager.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/{id}")
    public ResponseEntity<News> getById(@PathVariable String id) {
        Optional<News> news = newsRepository.findById(id);
        return new ResponseEntity<>(news.get(), HttpStatus.OK);
    }
}