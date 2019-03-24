package schrader.di.guice;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import schrader.di.common.AccountService;
import schrader.di.common.Car;

import javax.annotation.Nullable;

public class GuiceUserService {

    /**
     * Instead of @Autowired, Guice uses the @Inject annotation to inject the dependencies.
     */
    @Inject
    private AccountService accountService;

    @Inject
    @Nullable
    private Car nullableCar;

    @Inject(optional = true)
    private Optional<Car> optionalCar;

    public AccountService getAccountService() {
        return accountService;
    }

    @Nullable
    public Car getNullableCar() {
        return nullableCar;
    }

    public Optional<Car> getOptionalCar() {
        return optionalCar;
    }
}
