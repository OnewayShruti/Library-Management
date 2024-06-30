package com.example.library;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    LibraryRepository libraryRepository;
    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("/list-book-details")
    public ResponseEntity<List<Library>> listBookDetails() {
        return ResponseEntity.ok((List<Library>)libraryRepository.findAll());
    }

    @PostMapping("/add-book-details")
    public ResponseEntity<Library> addBookDetails(@RequestBody Library library) {
        libraryRepository.save(library);
        return ResponseEntity.ok(library);
    }

    @PutMapping("/update-copies-by-Id/{bookId}/{availableCopies}")
    public ResponseEntity<Library> updateCopiesById(@PathVariable Integer bookId,@PathVariable Integer availableCopies) {
        Library bookDetails = libraryRepository.findById(bookId).orElse(null);
        bookDetails.setAvailableCopies(availableCopies);
        libraryRepository.save(bookDetails);
        return ResponseEntity.ok(bookDetails);
    }

    @PutMapping("/issue-book-to-customer/{bookId}/{customerId}")
    public ResponseEntity<Library> issueBookToCustomerById(@PathVariable Integer bookId,@PathVariable Integer customerId) {
        Library bookDetails = libraryRepository.findByBookIdAndCustomerId(bookId,customerId);
        if(bookDetails.getAvailableCopies()!=0){
            bookDetails.setAvailableCopies(bookDetails.getAvailableCopies()-1);
            libraryRepository.save(bookDetails);
        }
        return ResponseEntity.ok(bookDetails);
    }
}
