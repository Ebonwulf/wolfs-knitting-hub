package com.nology.wolfsknittinghubbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins  = {"https://wolfs-knitting-hub-5h356xxfoq-nw.a.run.app/"} )
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book")
    public String getBook(@PathVariable String bookTitle) {
        return bookTitle;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> listOfBooks = this.bookRepository.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listOfBooks);
    }

    @PostMapping("/book")
    public String addBook(@RequestBody Book text) {
        this.bookRepository.save(text);
        return "Book saved";

    }

    @DeleteMapping("/book/{bookId}")
    @Transactional
    public String deleteBook(@PathVariable int bookId) {
        System.out.println("book = " + bookId);
        int deleted = this.bookRepository.deleteBookByBookId(bookId);
        if (deleted > 0) {
            return "Book removed";
        }
        return "Book Id doesn't exist";
    }
}
