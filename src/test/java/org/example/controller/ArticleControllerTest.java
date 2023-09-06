package org.example.controller;

import org.example.dto.ArticleDto;
import org.example.service.ArticleService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest
class ArticleControllerTest {
    ArticleController controller;

    @MockBean
    ArticleService articleService;

    List<ArticleDto> articles = new ArrayList<>();

    @BeforeEach
    void setUp() {
        controller = new ArticleController(articleService);
        articles = List.of(new ArticleDto(1, "hello-world", "Hello, World!", "Welcome to my applciation", LocalDateTime.now()));
    }

    @Test
    void shouldReturnAll() {
        Mockito.when(articleService.findAll()).thenReturn(articles);
        Assertions.assertEquals(1, controller.getAll().size());
    }

}