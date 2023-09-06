package org.example.dto;

import java.time.LocalDateTime;

public record ArticleDto (
        Integer id,
        String slug,
        String title,
        String content,
        LocalDateTime localDateTime
) {
}
