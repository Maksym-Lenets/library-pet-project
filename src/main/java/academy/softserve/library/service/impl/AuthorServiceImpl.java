package academy.softserve.library.service.impl;

import academy.softserve.library.model.Author;
import academy.softserve.library.repository.AuthorRepository;
import academy.softserve.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @Override
    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    @Transactional
    @Override
    public Author get(Long id){
        return authorRepository.get(id);
    }

    @Transactional
    @Override
    public List<Author> get(List<Long> ids) {
        return authorRepository.getList(ids);
    }

    @Transactional
    @Override
    public Author saveOrUpdate(Author author) {
        return authorRepository.saveOrUpdate(author);
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        return authorRepository.remove(id);
    }

}
