package academy.softserve.library.service.impl;

import academy.softserve.library.dto.RequestReadBookDto;
import academy.softserve.library.model.Request;
import academy.softserve.library.repository.RequestRepository;
import academy.softserve.library.service.RequestService;
import academy.softserve.library.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Transactional
    @Override
    public List<Request> getAll() {
        return requestRepository.getAll();
    }

    @Override
    @Transactional
    public List<RequestReadBookDto> getAllSuccessfulByUserId(Long userId) {
        return DtoUtil.toRequestReadBookDtoList(requestRepository.getAllSuccessfulByUserId(userId));
    }

    @Override
    @Transactional
    public List<Request> getAllNotReturnedInTime() {
        return requestRepository.getAllNotReturnedInTime();
    }

    @Transactional
    @Override
    public Request get(Long id) {
        return requestRepository.get(id);
    }

    @Transactional
    @Override
    public List<Request> get(LocalDate from, LocalDate to) {
        return requestRepository.get(from, to);
    }

    @Transactional
    @Override
    public Request saveOrUpdate(Request request) {
        return requestRepository.saveOrUpdate(request);
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        return requestRepository.remove(id);
    }
}
