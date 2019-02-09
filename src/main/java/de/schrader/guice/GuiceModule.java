package de.schrader.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import de.schrader.common.AccountService;
import de.schrader.common.BookService;
import de.schrader.common.BookServiceImpl;
import de.schrader.common.Car;

/**
 * Guice manages its dependencies in a special class called a module. A Guice module has to
 * extend the AbstractModule class and override its configure() method. Guice uses binding
 * as the equivalent to wiring in Spring.
 */
public class GuiceModule extends AbstractModule {

    /**
     * Normally, we expect Guice to instantiate each dependency object from their default
     * constructors if there isn’t any binding defined explicitly in the configure() method.
     * But since interfaces can’t be instantiated directly, we need to define bindings to
     * tell Guice which interface will be paired with which implementation.
     */
    @Override
    protected void configure() {
        bind(AccountService.class).to(GuiceAccountServiceImpl.class);
        bind(Car.class).toProvider(() -> null);
    }

    /**
     * As an equivalent of Spring’s @Bean annotation, Guice has a built-in annotation @Provides
     * to do the same job. Like @Bean, @Provides is only applied to the methods.
     */
    @Provides
    public BookService bookService() {
        return new BookServiceImpl();
    }
}
