package org.example.controller;

import org.example.dto.ArticleDto;
import org.example.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDto> getAll() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public ArticleDto getById(@PathVariable Integer id) {
        return articleService.getById(id);
    }
}
