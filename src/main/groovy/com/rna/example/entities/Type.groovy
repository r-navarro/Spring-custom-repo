package com.rna.example.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Type {

    @Id
    @GeneratedValue
    Long id

    String type
}
