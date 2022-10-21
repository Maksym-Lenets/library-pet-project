package academy.softserve.library.service.impl;

import academy.softserve.library.exception.IncorrectCredsExceptions;
import academy.softserve.library.exception.UserAlreadyExistException;
import academy.softserve.library.exception.UserNotFoundException;
import academy.softserve.library.model.User;
import academy.softserve.library.repository.UserRepository;
import academy.softserve.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j(topic = "User Service")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) throws UserNotFoundException, SQLException, UserAlreadyExistException {
        if (checkIfExist(user.getEmail())) {
            log.info("Created new user" + user);
            return userRepository.addUser(user);
        } else {
            log.error("User with email " + user.getEmail() + " is already exist");
            throw new UserAlreadyExistException("User with email " + user.getEmail() + " is already exist!");
        }
    }

    @Override
    public User getUserById(long id) throws UserNotFoundException {
        Optional<User> byId = Optional.ofNullable(userRepository.get(id));
        if (byId.isPresent()) {
            log.info("Information about user with id " + id + " ready for you");
            return byId.get();
        } else {
            log.error("User with id " + id + " is not exist");
            throw new UserNotFoundException("User with id " + id + " is not exist");
        }
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        if (userByEmail.isPresent()) {
            return userByEmail.get();
        } else throw new UserNotFoundException("User with email" + email + " is not exist");
    }

    @Override
    public boolean checkIfExist(String email) throws SQLException {
        Optional<User> byId = userRepository.findUserByEmail(email);
        return byId.isEmpty();
    }

    @Override
    public User login(String email, String password) throws IncorrectCredsExceptions, UserNotFoundException {
        Optional<User> byEmail = userRepository.findUserByEmail(email);
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (user.getPassword().equals(password)) {
                log.info("User " + user.getEmail() + " entered");
                return user;
            } else throw new IncorrectCredsExceptions("You entered incorrect password");
        } else throw new UserNotFoundException("User with email" + email + " is not exist");
    }

    @Override
    public void deleteUser(long id) throws UserNotFoundException {
        Optional<User> byId = Optional.ofNullable(userRepository.get(id));
        if (byId.isPresent()) {
            userRepository.remove(id);
            log.info("User with id " + id + " was deleted");
        } else {
            log.error("User with id " + id + " is not exist");
            throw new UserNotFoundException("User with id " + id + " is not exist");
        }
    }
}
