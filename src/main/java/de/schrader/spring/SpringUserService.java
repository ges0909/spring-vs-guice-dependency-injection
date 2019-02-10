package de.schrader.spring;

import de.schrader.common.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring declares the dependency injection configurations in a special configuration class.
 * This class must be annotated by the @Configuration annotation. The Spring container uses
 * this class as a source of bean definitions. Classes managed by Spring are called Spring
 * beans.
 */
@Component
public class SpringUserService {

    /**
     * Spring uses the @Autowired annotation to wire the dependencies automatically. @Autowired
     * is part of Spring’s built-in core annotations. We can use @Autowired on member variables,
     * setter methods, and constructors.
     *
     * Spring also supports @Inject. @Inject is part of the Java CDI (Contexts and Dependency
     * Injection) that defines a standard for dependency injection.
     *
     * Field-based injection uses reflection to inject the dependencies, which is costlier than
     * constructor-based or setter-based injection.
     */
    @Autowired
    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }
}
