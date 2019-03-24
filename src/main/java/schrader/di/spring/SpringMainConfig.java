package schrader.di.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import schrader.di.common.BookService;
import schrader.di.common.BookServiceImpl;

/**
 * Spring's @ComponentScan annotation will tell Spring where to search for annotated components.
 */
@Configuration
@ComponentScan("schrader.di.spring")
public class SpringMainConfig {

    /**
     * Spring also provides a method level annotation @Bean to register beans as an
     * alternative to its class level annotations like @Component. The return value
     * of a @Bean annotated method is registered as a bean in the container. If we
     * don’t specify a custom name, the bean name will default to the method name.
     * <p>
     * For a bean with the default singleton scope, Spring first checks if a cached
     * instance of the bean already exists and only creates a new one if it does not.
     * If we’re using the prototype scope, the container returns a new bean instance
     * for each method call.
     */
    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }
}
