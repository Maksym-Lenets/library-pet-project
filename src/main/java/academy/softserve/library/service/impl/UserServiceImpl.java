package academy.softserve.library.service.impl;

import academy.softserve.library.model.User;
import academy.softserve.library.repository.UserRepository;
import academy.softserve.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
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
            return byId.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        Optional<User> userByEmail = Optional.ofNullable(userRepository.findUserByEmail(email));
        if (userByEmail.isPresent()) {
            return userByEmail.get();
        } else {
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
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(long id) {
        return userRepository.remove(id);
    }
}
