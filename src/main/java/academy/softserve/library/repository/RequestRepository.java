package academy.softserve.library.repository;

import academy.softserve.library.model.Request;

import java.time.LocalDate;
import java.util.List;

public interface RequestRepository extends GenericRepository<Request, Long> {
    List<Request> get(LocalDate from, LocalDate to);
    List<Request> getAllSuccessfulByUserId(Long id);
    List<Request> getAllNotReturnedInTime();

    Request getNotReturnedByUserAndBookId(Long userId, Long bookId);
}

