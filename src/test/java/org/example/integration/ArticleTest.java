package org.example.integration;

import org.example.model.ArticleEntity;
import org.example.repository.ArticleRepository;
import org.example.util.Examplify;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("unit")
public class ArticleTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private Examplify examplify;

    @Test
    public void shouldSaveArticle() {
        ArticleEntity articleEntity = new ArticleEntity(examplify.getSlugExpression(), examplify.getTitleExpression(), examplify.getContentExpression(), examplify.getLocalDateExpression());

        var savedArticle = articleRepository.save(articleEntity);
        assertThat(savedArticle).usingRecursiveComparison().ignoringFields("id").isEqualTo(articleEntity);

        var existingArticle = articleRepository.getById(savedArticle.getId());
        assertThat(savedArticle).usingRecursiveComparison().isEqualTo(existingArticle);
    }

    @Test
    @Sql("classpath:init-test.sql")
    public void shouldFindArticleToDatabase() {
        Optional<ArticleEntity> dummy = articleRepository.findById(1);
        assertThat(dummy).isNotEmpty();
    }
}
