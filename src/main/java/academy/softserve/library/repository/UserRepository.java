package academy.softserve.library.repository;

import academy.softserve.library.model.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User, Long> {
    User findUserByEmail(String email);

    User save(User user);

    User update(User user);
}
