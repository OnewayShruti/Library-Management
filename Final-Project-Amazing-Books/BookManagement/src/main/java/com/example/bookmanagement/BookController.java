package com.example.bookmanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-management")
public class BookController {

    BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/list-all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok((List<Book>) bookRepository.findAll());
    }

    @PostMapping("/add-new-book")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Book added!");
    }

    @PutMapping("/update-book-by-Id/{bookId}/{totalCopies}/{issuedCopies}")
    public ResponseEntity<String> updateBook(@PathVariable int bookId , @PathVariable int totalCopies , @PathVariable int issuedCopies) {
        Book book = bookRepository.findById(bookId).orElse(null);
        book.setTotalCopies(totalCopies);
        book.setIssuedCopies(issuedCopies);
        bookRepository.save(book);
        return ResponseEntity.ok("Book updated!");
    }

    @DeleteMapping("/delete-book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        bookRepository.deleteById(bookId);
        return ResponseEntity.ok("Book deleted!");
    }

}
