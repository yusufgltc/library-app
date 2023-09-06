package org.example.conventers;

import org.example.dto.ArticleDto;
import org.example.model.ArticleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleConverter  {
    ArticleDto fromEntityToDto(ArticleEntity article);

    ArticleEntity fromDtoToEntity(ArticleDto articleDto);
}
