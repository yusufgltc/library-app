package org.example.repository;

import liquibase.pro.packaged.A;
import org.example.conventers.ArticleConverter;
import org.example.dto.ArticleDto;
import org.example.model.ArticleEntity;
import org.example.service.ArticleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Testcontainers
@AutoConfigurationTestDatabase(replace = AutoConfigurationTestDatabase.Replace.NONE)
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void shouldFindById() {
        ArticleEntity expected = new ArticleEntity("hello-world", "hello world", "lorem impus bla bla bla", LocalDateTime.now());
        ArticleEntity actual = articleRepository.save(expected);
        assertThat(actual).usingRecursiveComparison().ignoringFields("id").isEqualTo(expected);
    }
}