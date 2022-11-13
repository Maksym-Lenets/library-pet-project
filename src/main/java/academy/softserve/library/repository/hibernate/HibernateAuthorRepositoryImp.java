package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Author;
import academy.softserve.library.repository.AuthorRepository;
import org.hibernate.Hibernate;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateAuthorRepositoryImp implements AuthorRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateAuthorRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Author").getResultList();
    }

    @Override
    public Author get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Author.class, id);
    }

    @Override
    public List<Author> getAuthorsByName(String... names) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);

        List<Predicate> predicates = new ArrayList<>();
        for (String firstName : names) {
            Predicate p = criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
            predicates.add(p);
        }
        for (String lastName : names) {
            Predicate p = criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
            predicates.add(p);
        }

        Predicate finalPredicate = criteriaBuilder.or(predicates.toArray(new Predicate[0]));

        criteriaQuery.where(finalPredicate);
        List<Author> authors = session.createQuery(criteriaQuery).getResultList();
        for (Author author : authors) {
            Hibernate.initialize(author.getBookList());
            Hibernate.initialize(author.getBooks());
        }

        return authors;
    }

    public List<Author> getByIds(List<Long> ids) {
        MultiIdentifierLoadAccess<Author> authorsLoader = sessionFactory.getCurrentSession().byMultipleIds(Author.class);
        return authorsLoader.multiLoad(ids);
    }

    @Override
    public Author saveOrUpdate(Author element) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(element);
        return element;
    }

    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = get(id);
        if (author == null) return false;
        session.remove(author);
        return true;
    }
}
