package academy.softserve.library.repository;

import academy.softserve.library.model.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User, Long> {
    public User addUser(User user);
    Optional<User> findUserByEmail(String email);
}
