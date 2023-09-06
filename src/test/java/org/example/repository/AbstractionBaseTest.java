package org.example.repository;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public class AbstractionBaseTest
{
    @Container
    private static final PostgreSQLContainer container;

    static{
        container = new PostgreSQLContainer "postgres:11.8").withUsername("admin").withPassword("admin");
        container.start();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);;
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }
}
