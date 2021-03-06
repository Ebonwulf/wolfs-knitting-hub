package com.nology.wolfsknittinghubbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.util.Elements;
import javax.persistence.Access;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins  = {"https://wolfs-knitting-hub-5h356xxfoq-nw.a.run.app", "https://ebonwulf.github.io", "http://localhost:3000"} )
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/knitting-hub-frontend/book")
    public String getBook(@PathVariable String bookTitle) {
        return bookTitle;
    }

    @GetMapping("/knitting-hub-frontend/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> listOfBooks = this.bookRepository.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listOfBooks);
    }

    @PostMapping("/knitting-hub-frontend/book")
    public String addBook(@RequestBody Book text) {
        this.bookRepository.save(text);
        return "Book saved";

    }

    @DeleteMapping("/knitting-hub-frontend/book/{bookId}")
    @Transactional
    public String deleteBook(@PathVariable int bookId) {
        System.out.println("book = " + bookId);
        int deleted = this.bookRepository.deleteBookByBookId(bookId);
        if (deleted > 0) {
            return "Book removed";
        }
        return "Book Id doesn't exist";
    }

    @PutMapping("/knitting-hub-frontend/books/{bookId}")
    public String updateBook(@RequestBody Book text, @PathVariable int bookId) {
        this.bookRepository.save(text);
        System.out.println("book = " + bookId);
        return "Book updated";
    }
}
