package com.rna.example.repositories

import com.rna.example.entities.Book
import com.rna.example.repositories.pogo.BookSearchCriteria

interface BookRepositoryCustom {

    List<Book> findByCriteria(BookSearchCriteria bookSearchCriteria)
}