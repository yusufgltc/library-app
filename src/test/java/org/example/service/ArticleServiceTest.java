package org.example.service;

import org.example.conventers.ArticleConverter;
import org.example.dto.ArticleDto;
import org.example.model.ArticleEntity;
import org.example.repository.ArticleRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    private ArticleService articleService;

    ArticleConverter articleConverter = new ArticleConverter() {
        @Override
        public ArticleDto fromEntityToDto(ArticleEntity article) {
            return null;
        }

        @Override
        public ArticleEntity fromDtoToEntity(ArticleDto articleDto) {
            return null;
        }
    };

    @BeforeEach
    void setup() {
        articleService = new ArticleService(articleRepository, articleConverter);
    }

    @Test
    void shouldGetAndReturnOneArticle() {
        var expectedArticleEntity = new ArticleEntity("hello-world", "hello world", "lorem impus bla bla bla", LocalDateTime.now());
        when(articleRepository.getById(anyInt())).thenReturn(expectedArticleEntity);
        var actualArticleEntity = articleService.getById(getRandomInt());
        assertThat(articleConverter.fromDtoToEntity(actualArticleEntity)).usingRecursiveComparison().isEqualTo(expectedArticleEntity);
        verify(articleRepository, times(1)).getById(anyInt());
        verifyNoInteractions(articleRepository);
    }

    @Test
    void shouldGetAndReturnAllArticles() {
        when(articleRepository.findAll()).thenReturn(List.of(new ArticleEntity(), new ArticleEntity()));
        Assertions.assertEquals(2, articleService.findAll());
    }
}