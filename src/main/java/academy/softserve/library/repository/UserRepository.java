package academy.softserve.library.repository;

import academy.softserve.library.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends GenericRepository<User, Long> {
    User findUserByEmail(String email);

    User save(User user);

    User update(User user);

    List<LocalDate> getAverageAge();
}
