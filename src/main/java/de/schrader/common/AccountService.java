package de.schrader.common;

public interface AccountService {

    default String getName() {
        return "This is the name of the account service.";
    }
}
