package service;

import dao.UserDAO;

public class AuthService {

    UserDAO dao =
            new UserDAO();

    public boolean login(
            String username,
            String password
    ) {

        return dao.login(
                username,
                password
        );
    }
}