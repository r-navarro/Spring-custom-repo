package com.rna.example.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Author {

    @Id
    @GeneratedValue
    Long id

    String firstName

    String lastName

    @OneToMany
    List<Book> books
}
