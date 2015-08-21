package com.rna.example.entities

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Book {

    @Id
    @GeneratedValue
    Long id

    String title

    @ManyToOne(cascade = CascadeType.PERSIST)
    Author author

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Type> types = []
}
