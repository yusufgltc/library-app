package org.example.service;

import org.example.conventers.ArticleConverter;
import org.example.dto.ArticleDto;
import org.example.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    private final ArticleConverter articleConverter;

    public ArticleService(ArticleRepository articleRepository, ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().map(articleConverter::fromEntityToDto).collect(Collectors.toList());
    }

    public ArticleDto getById(Integer id) {
        var article = articleRepository.getById(id);
        return articleConverter.fromEntityToDto(article);
    }
}
