package de.schrader;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.schrader.common.BookService;
import de.schrader.guice.GuiceModule;
import de.schrader.guice.GuiceUserService;
import de.schrader.spring.SpringMainConfig;
import de.schrader.spring.SpringUserService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SpringVsGuiceTests {

    private final static String TEST_NAME = "This is the name of the account service.";

    /**
     * We need to define an application context to access the Spring beans. Then at
     * runtime, we can retrieve the AccountService instance from our UserService bean.
     */
    private final ApplicationContext context = new AnnotationConfigApplicationContext(SpringMainConfig.class);

    /**
     * Then, we need to define an Injector using GuiceModule to get instances of our
     * classes. This module defines defines the interface-implementation bindings.
     */
    private final Injector injector = Guice.createInjector(new GuiceModule());

    @Nested
    class SpringTests {

        @Test
        void componentAnnotation() {
            SpringUserService userService = context.getBean(SpringUserService.class);
            assertThat(userService).isNotNull();
            assertThat(userService.getAccountService()).isNotNull();
            assertThat(userService.getAccountService().getName()).isNotNull().isEqualTo(TEST_NAME);
        }

        @Test
        void beanAnnotation() {
            BookService bookService = context.getBean(BookService.class);
            assertThat(bookService).isNotNull();
        }
    }

    @Nested
    class GuiceTests {

        @Test
        void moduleConfigure() {
            GuiceUserService userService = injector.getInstance(GuiceUserService.class);
            assertThat(userService).isNotNull();
            assertThat(userService.getAccountService()).isNotNull();
            assertThat(userService.getAccountService().getName()).isNotNull().isEqualTo(TEST_NAME);
        }

        @Test
        void provideAnnotation() {
            BookService bookService = injector.getInstance(BookService.class);
            assertThat(bookService).isNotNull();
        }

        @Test
        void providerGeneric() {
            GuiceUserService userService = injector.getInstance(GuiceUserService.class);
            assertThat(userService).isNotNull();
            assertThat(userService.getNullableCar()).isNull();
            assertThat(userService.getOptionalCar()).isNull();
        }
    }
}
