package com.rna.example

import com.rna.example.entities.Author
import com.rna.example.entities.Book
import com.rna.example.entities.Type
import com.rna.example.repositories.BookRepository
import com.rna.example.repositories.pogo.BookSearchCriteria
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("com.rna.example")
@EnableJpaRepositories("com.rna.example.repositories")
class Application implements InitializingBean {

    @Autowired
    BookRepository bookRepository

    static void main(String... args) {
        SpringApplication.run(Application, args)
    }

    @Override
    void afterPropertiesSet() throws Exception {
        def author1 = new Author(firstName: 'toto', lastName: 'tata')

        def type1 = new Type(type: 'type1')

        def book1 = new Book(title: 'book1', author: author1)
        book1.types << type1

        bookRepository.save(book1)

        BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(authorLastName: 'tata')

        def books = bookRepository.findByCriteria(bookSearchCriteria)

        println books
    }
}
