package academy.softserve.library.repository;

import academy.softserve.library.model.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User, Long> {
    public boolean addUser(User user);
    Optional<User> findUserByEmail(String email);
}
