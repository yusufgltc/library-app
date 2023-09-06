package org.example.conventers;

import org.example.dto.ArticleDto;
import org.example.model.ArticleEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ArticleConverterTest {

    private final ArticleConverter articleConverter = Mappers.getMapper(ArticleConverter.class);

    @Test
    public void shouldMapArticleToDto() {
        //given
        ArticleEntity articleEntity = new ArticleEntity("hello-world", "hello world", "lorem impus bla bla bla", LocalDateTime.now());

        //when
        ArticleDto articleDto = articleConverter.fromEntityToDto(articleEntity);

        //then
        Assertions.assertNotNull(articleDto);
        Assertions.assertEquals("hello world", articleDto.title());
    }

}