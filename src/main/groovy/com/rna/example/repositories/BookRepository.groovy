package com.rna.example.repositories

import com.rna.example.entities.Book
import org.springframework.data.repository.PagingAndSortingRepository

interface BookRepository extends PagingAndSortingRepository<Book, Long>, BookRepositoryCustom {

}