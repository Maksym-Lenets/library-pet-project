package academy.softserve.library.service;

import academy.softserve.library.exception.IncorrectCredsExceptions;
import academy.softserve.library.exception.UserAlreadyExistException;
import academy.softserve.library.exception.UserNotFoundException;
import academy.softserve.library.model.Book;
import academy.softserve.library.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();
    User getUserById(long id) ;

    User getUserByEmail(String email);
    User save(User user);
    User update(User user);


    User login(String email, String password) ;

    boolean deleteUser(long id);
}
