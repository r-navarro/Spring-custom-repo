package com.rna.example.controllers

import com.rna.example.repositories.BookRepository
import com.rna.example.repositories.pogo.BookSearchCriteria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BooksController {

    @Autowired
    BookRepository bookRepository

    @RequestMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute('message', 'yeah !!')
        model.addAttribute('criteria', new BookSearchCriteria())

        return 'welcome'
    }

    @RequestMapping("/result")
    public String result(@ModelAttribute("criteria")BookSearchCriteria criteria, Model model){

        def books = bookRepository.findByCriteria(criteria)

        model.addAttribute('books', books)
        return 'result'
    }
}
