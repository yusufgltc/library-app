package org.example.util;

import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Examplify {
    private static Faker faker = new Faker();
    public String getTitleExpression() {
        return faker.expression("#{examplify 'Lorem Impus'}");
    }
    public String getSlugExpression() {
        return faker.expression("#{examplify 'Lorem Impus'}");
    }

    public String getContentExpression() {
        return faker.expression("#{examplify 'Also there could a third argument telling if characters should be! '}");
    }

    public LocalDateTime getLocalDateExpression() {
        return faker.date().birthday().toLocalDateTime();
    }
}
