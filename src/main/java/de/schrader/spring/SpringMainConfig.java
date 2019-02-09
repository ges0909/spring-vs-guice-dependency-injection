package de.schrader.spring;

import de.schrader.common.BookService;
import de.schrader.common.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring's @ComponentScan annotation will tell Spring where to search for annotated components.
 */
@Configuration
@ComponentScan("de.schrader")
public class SpringMainConfig {

    /**
     * Spring also provides a method level annotation @Bean to register beans as an
     * alternative to its class level annotations like @Component. The return value
     * of a @Bean annotated method is registered as a bean in the container.
     */
    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }
}
