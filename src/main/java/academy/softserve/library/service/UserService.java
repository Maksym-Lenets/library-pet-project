package academy.softserve.library.service;

import academy.softserve.library.exception.IncorrectCredsExceptions;
import academy.softserve.library.exception.UserAlreadyExistException;
import academy.softserve.library.exception.UserNotFoundException;
import academy.softserve.library.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user) throws UserNotFoundException, SQLException, UserAlreadyExistException;

    User getUserById(int id) throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;

    boolean checkIfExist(String email) throws SQLException;

    User login(String email, String password) throws IncorrectCredsExceptions;

    void deleteUser(int id) throws UserNotFoundException;
}
