package schrader.di.spring;

import schrader.di.common.AccountService;
import org.springframework.stereotype.Component;

/**
 * Even though we’ve annotated AccountServiceImpl, Spring can map it by @Autowired to the
 * AccountService since it implements AccountService.
 */
@Component
public class SpringAccountServiceImpl implements AccountService {
}
