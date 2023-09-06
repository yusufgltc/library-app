package org.example.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String title;
    private String content;
    private LocalDateTime localDateTime;

    public ArticleEntity(String s, String helloWorld, String loremImpusBlaBlaBla, LocalDateTime now) {

    }

    public ArticleEntity(Integer id, String slug, String title, String content, LocalDateTime localDateTime) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.content = content;
        this.localDateTime = localDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
