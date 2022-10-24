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
//@Slf4j(topic = "User Service")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        Optional<User> byId = Optional.ofNullable(userRepository.get(id));
        if (byId.isPresent()) {
            // log.info("Information about user with id " + id + " ready for you");
            return byId.get();
        } else {
            // log.error("User with id " + id + " is not exist");
            return null;
        }
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        Optional<User> userByEmail = Optional.ofNullable(userRepository.findUserByEmail(email));
        if (userByEmail.isPresent()) {
            // log.info("Information about user with email " + email + " ready for you");
            return userByEmail.get();
        } else {
            // log.error("User with email " + email + " is not exist");
            return null;
        }
    }


    @Override
    @Transactional
    public User login(String email, String password) {
        Optional<User> byEmail = Optional.ofNullable(userRepository.findUserByEmail(email));
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (user.getPassword().equals(password)) {
                //   log.info("User " + user.getEmail() + " entered");
                return user;
            } else {
                //  log.error("Incorrect password");
                return null;
            }
        } else {
            //  log.error("User with email " + email + " is not exist");
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(long id) {
        return  userRepository.remove(id);


    }
}
