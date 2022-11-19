package academy.softserve.library.service;

import academy.softserve.library.model.Request;

import java.time.LocalDate;
import java.util.List;

public interface RequestService {
    List<Request> getAll();
    List<Request> getAllByUserId(Long userId);
    Request get(Long id);
    List<Request> get(LocalDate from, LocalDate to);
    Request saveOrUpdate(Request author);
    boolean delete(Long id);

}
