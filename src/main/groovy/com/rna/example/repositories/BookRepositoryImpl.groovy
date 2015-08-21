package com.rna.example.repositories

import com.rna.example.entities.Author
import com.rna.example.entities.Book
import com.rna.example.entities.Type
import com.rna.example.repositories.pogo.BookSearchCriteria

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Join
import javax.persistence.criteria.Root

class BookRepositoryImpl implements  BookRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager

    @Override
    List<Book> findByCriteria(BookSearchCriteria bookSearchCriteria) {

        def criteriaBuilder = entityManager.getCriteriaBuilder()

        CriteriaQuery<Book> bookQuery = criteriaBuilder.createQuery(Book)

        Root<Book> rootBook = bookQuery.from(Book)

        if (bookSearchCriteria.authorLastName) {
            Join<Book, Author> authorJoin = rootBook.join('author')
            def authorLastNamePredicate = criteriaBuilder.equal(authorJoin.get('lastName'), criteriaBuilder.literal(bookSearchCriteria.authorLastName))
            bookQuery.where(authorLastNamePredicate)
        }

        if(bookSearchCriteria.type){
            Join<Book, Type> typeJoin = rootBook.join('types')
            def typePredicate = criteriaBuilder.equal(typeJoin.get('type'), criteriaBuilder.literal(bookSearchCriteria.type))
            bookQuery.where(typePredicate)
        }


        return entityManager.createQuery(bookQuery).getResultList()
    }
}
